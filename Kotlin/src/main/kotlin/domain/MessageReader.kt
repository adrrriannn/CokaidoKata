package domain

import MessageRepository

class MessageReader(val messageRepository: MessageRepository) {

    operator fun invoke(user: User): Posts {
        return messageRepository.findByUser(user)
    }
}
