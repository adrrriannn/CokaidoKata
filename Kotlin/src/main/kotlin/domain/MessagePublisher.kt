package domain

import MessageRepository

class MessagePublisher(val messageRepository: MessageRepository) {

    operator fun invoke(user: User, message: Message) {
        messageRepository.save(Post(user, message))
    }
}
