package infrastructure

import application.PublishMessage
import application.ReadMessage
import java.lang.UnsupportedOperationException

class SocialNetwork(private val publishMessage: PublishMessage, private val readMessage: ReadMessage) {

    fun execute(inputText: String): String {
        val textList = inputText.split("-> ")

        return when(parseCommand(inputText)) {
            "publish" -> {
                publishMessage.publish(textList[0], textList[1])
                ""
            }
            "read" -> {
                val message = readMessage.read(textList[0])
                if (message.isBlank()) {
                    message
                } else {
                    "$message (5 minutes ago)"
                }
            }
            else      -> throw UnsupportedOperationException("noooooooorl")
        }
    }

    private fun parseCommand(inputText: String): Any {
        val textList = inputText.split("-> ")
        if(textList.size > 1) return "publish"

        return "read"
    }
}