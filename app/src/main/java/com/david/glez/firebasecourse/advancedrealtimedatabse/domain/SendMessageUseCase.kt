package com.david.glez.firebasecourse.advancedrealtimedatabse.domain

import com.david.glez.firebasecourse.advancedrealtimedatabse.data.network.FirebaseChatService
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(private val firebaseChatService: FirebaseChatService) {

    operator fun invoke(message: String) {
        firebaseChatService.sedMsgToFirebase(msg = message)
    }
}