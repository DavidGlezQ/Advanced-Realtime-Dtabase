package com.david.glez.firebasecourse.advancedrealtimedatabse.ui.chat

import androidx.lifecycle.ViewModel
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val sendMessageUseCase: SendMessageUseCase) :
    ViewModel() {

    fun sendMessage() {
        val message = "Hello"
        sendMessageUseCase(message)
    }
}