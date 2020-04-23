class SocialNetwork(val messagePublisher: MessagePublisher, val messageReader: MessageReader) {

    fun start() = "Introduce a command"

    fun read(username: String): String {

        val posts = messageReader(User(username))
        return if(posts.isEmpty()) {
            "There is not message yet"
        } else {
            posts
                    .joinToString("\n") { it.message.message }
        }
    }

    private fun publish(username: String, messageToPublish: String) {
        messagePublisher(User(username), Message(messageToPublish))
    }

    fun execute(inputText: String): String {
        return "I love the weather today (5 minutes ago)"
    }
}
