package com.david.glez.firebasecourse.advancedrealtimedatabse.domain

import com.david.glez.firebasecourse.advancedrealtimedatabse.data.network.FirebaseChatService
import javax.inject.Inject

class GetMessageUseCase @Inject constructor(private val firebaseChatService: FirebaseChatService) {
    operator fun invoke() = firebaseChatService.getMessage()
}