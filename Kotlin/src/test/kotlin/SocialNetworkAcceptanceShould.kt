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
    fun `publish a message in a timeline`() {

        val messageToPublish = "I love the weather today"
        val messageTimestamp = "(5 minutes ago)"

        val expectedOutput = "$messageToPublish $messageTimestamp"

        val person = "Alice"

        socialNetwork.publish(person, messageToPublish)

        val output = socialNetwork.read(person)

        assertThat(output).isEqualTo(expectedOutput)
    }

}
