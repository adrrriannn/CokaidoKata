import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SocialNetworkShould {

    private val messageRepository: MessageRepository = mockk()
    private val messagePublisher = MessagePublisher(messageRepository)
    private val messageReader = MessageReader(messageRepository)

    private val socialNetwork = SocialNetwork(messagePublisher, messageReader)

    @Test
    fun `publish a message into someone's timeline`() {
        val username = "Alice"
        val inputMessage = "I love the weather today"

        val user = User(username)
        val message = Message(inputMessage)

        val post = Post(user, message)

        every { messageRepository.save(post) } just Runs

        socialNetwork.publish(username, inputMessage)

        verify {
            messageRepository.save(post)
        }
    }

    @Test
    fun `return no messages for empty timeline`() {

        val outputWhenEmptyTimeline = "There is not message yet"

        val username = "Alice"

        every { messageRepository.findByUser(User(username)) } returns Posts()

        val output = socialNetwork.read(username)

        assertThat(output).isEqualTo(outputWhenEmptyTimeline)
    }

    @Test
    fun `read someone's timeline with one post`() {

        val messageText = "This is a message (5 minutes ago)"
        val message = Message(messageText)

        val username = "Alice"
        val user = User(username)

        val post = Post(user, message)

        val expectedPosts = listOf(post)

        every { messageRepository.findByUser(user) } returns Posts(expectedPosts)

        val output = socialNetwork.read(username)

        assertThat(output).isEqualTo(messageText)
    }

}
