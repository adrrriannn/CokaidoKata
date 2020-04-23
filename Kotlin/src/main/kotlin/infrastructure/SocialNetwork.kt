package infrastructure

import domain.Message
import domain.MessagePublisher
import domain.User
import application.ReadMessage

class SocialNetwork(val messagePublisher: MessagePublisher, val readMessage: ReadMessage) {

    fun start() = "Introduce a command"

    fun execute(inputText: String): String {
        val textList = inputText.split("-> ")

        return if(textList.size > 1){
            publish(textList[0], textList[1])
            ""
        }
        else {
            val message = readMessage.read(textList[0])

            return if(message.isBlank()) {
                message
            } else {
                "$message (5 minutes ago)"
            }
        }
    }

    private fun publish(username: String, messageToPublish: String) {
        messagePublisher(User(username), Message(messageToPublish))
    }

}