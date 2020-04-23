package infrastructure

import application.PublishMessage
import application.ReadMessage

class SocialNetwork(private val commandFactory: CommandFactory) {
    fun execute(inputText: String) = commandFactory.buildCommand(inputText).execute()
}

class CommandFactory(private val publishMessage: PublishMessage, private val readMessage: ReadMessage) {

    fun buildCommand(text: String): Command {
        val textList = text.split("-> ")
        if (textList.size > 1) return Command.Publish(publishMessage, textList[0], textList[1])

        return Command.Read(readMessage, textList[0])
    }
}

sealed class Command {

    abstract fun execute(): String

    class Read(private val readMessage: ReadMessage, val user: String) : Command() {
        override fun execute(): String {
            val message = readMessage.read(user)
            return if (message.isBlank()) {
                message
            } else {
                "$message (5 minutes ago)"
            }
        }
    }

    class Publish(private val publishMessage: PublishMessage, val user: String, val message: String) : Command() {
        override fun execute(): String {
            publishMessage.publish(user, message)
            return ""
        }
    }
}