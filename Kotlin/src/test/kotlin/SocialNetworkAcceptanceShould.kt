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
}
