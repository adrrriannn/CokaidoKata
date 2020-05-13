package application

import domain.MessageReader
import domain.User

class ReadMessage(val messageReader: MessageReader) {

    fun read(username: String) = messageReader(User(username)).joinToString("\n") { it.message.message }

}