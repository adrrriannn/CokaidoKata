import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SocialNetworkAcceptanceShould {

    private val messageRepository = InMemoryMessageRepository()
    private val messagePublisher = MessagePublisher(messageRepository)
    private val messageReader = MessageReader(messageRepository)
    private val socialNetwork = SocialNetwork(messagePublisher, messageReader)

    @Test
    fun `prompt users to introduce commands`() {

        val promptUsersMessage = "Introduce a command"

        val output = socialNetwork.start()
        assertThat(output).isEqualTo(promptUsersMessage)
    }

    @Test
    fun `publish a message in Alice's timeline`() {
        socialNetwork.execute("Alice -> I love the weather today")

        val output = socialNetwork.execute("Alice")

        assertThat(output).isEqualTo("I love the weather today (5 minutes ago)")
    }

    @Test
    fun `publish another message in Alice's timeline`() {
        socialNetwork.execute("Alice -> Hello")

        val output = socialNetwork.execute("Alice")

        assertThat(output).isEqualTo("Hello (5 minutes ago)")
    }

    @Test
    fun `publish a message in a Bob's timeline`() {
        socialNetwork.execute("Bob -> Damn! We lost!")

        val output = socialNetwork.execute("Bob")

        assertThat(output).isEqualTo("Damn! We lost! (5 minutes ago)")
    }
}
