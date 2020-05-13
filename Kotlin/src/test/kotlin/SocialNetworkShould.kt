import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SocialNetworkShould {
/*
    private val messageRepository: MessageRepository = mockk()
    private val messagePublisher = domain.MessagePublisher(messageRepository)
    private val messageReader = domain.MessageReader(messageRepository)

    private val socialNetwork = infrastructure.SocialNetwork(messagePublisher, messageReader)

    @Test
    fun `publish a message into someone's timeline`() {
        val username = "Alice"
        val inputMessage = "I love the weather today"

        val user = domain.User(username)
        val message = domain.Message(inputMessage)

        val post = domain.Post(user, message)

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

        every { messageRepository.findByUser(domain.User(username)) } returns domain.Posts()

        val output = socialNetwork.read(username)

        assertThat(output).isEqualTo(outputWhenEmptyTimeline)
    }

    @Test
    fun `read someone's timeline with one post`() {

        val messageText = "This is a message (5 minutes ago)"
        val message = domain.Message(messageText)

        val username = "Alice"
        val user = domain.User(username)

        val post = domain.Post(user, message)

        val expectedPosts = listOf(post)

        every { messageRepository.findByUser(user) } returns domain.Posts(expectedPosts)

        val output = socialNetwork.read(username)

        assertThat(output).isEqualTo(messageText)
    }
*/
}
