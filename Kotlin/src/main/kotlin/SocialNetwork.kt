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

    fun publish(username: String, messageToPublish: String) {
        messagePublisher(User(username), Message(messageToPublish))
    }

}
