import domain.Message
import domain.Post
import domain.Posts
import domain.User

interface MessageRepository {
    fun save(post: Post)
    fun findByUser(user: User): Posts


}

class InMemoryMessageRepository : MessageRepository {
    private var message = Post(User(""), Message(""))

    override fun findByUser(user: User) = Posts(listOf(message))

    override fun save(post: Post) {
        message = post
    }

}
