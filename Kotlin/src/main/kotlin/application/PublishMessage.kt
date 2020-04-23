package application

import domain.Message
import domain.MessagePublisher
import domain.User

class PublishMessage(val messagePublisher: MessagePublisher) {
    fun publish(username: String, messageToPublish: String) {
        messagePublisher(User(username), Message(messageToPublish))
    }
}