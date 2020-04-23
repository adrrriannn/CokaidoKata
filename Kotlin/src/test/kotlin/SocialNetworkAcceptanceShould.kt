import application.PublishMessage
import application.ReadMessage
import domain.MessagePublisher
import domain.MessageReader
import infrastructure.SocialNetwork
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SocialNetworkAcceptanceShould {

    private val messageRepository = InMemoryMessageRepository()
    private val messagePublisher = MessagePublisher(messageRepository)
    private val messageReader = MessageReader(messageRepository)
    private val readMessage = ReadMessage(messageReader)
    private val publishMessage = PublishMessage(messagePublisher)
    private val socialNetwork = SocialNetwork(publishMessage, readMessage)


    @Test
    fun `read empty line with the user has no posts`() {
        val output = socialNetwork.execute("Pepito")
        assertThat(output).isEqualTo("")
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
