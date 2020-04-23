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
        val textList = inputText.split("-> ")

        return if(textList.size > 1){
            publish(textList[0], textList[1])
            ""
        }
        else {
            read(textList[0])
        }
    }
}
