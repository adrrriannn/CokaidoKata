interface MessageRepository {
    fun save(post: Post)
    fun findByUser(user: User): Posts


}

class InMemoryMessageRepository: MessageRepository {
    override fun findByUser(user: User): Posts {
        throw UnsupportedOperationException()
    }

    override fun save(post: Post) {
        throw UnsupportedOperationException()
    }

}
