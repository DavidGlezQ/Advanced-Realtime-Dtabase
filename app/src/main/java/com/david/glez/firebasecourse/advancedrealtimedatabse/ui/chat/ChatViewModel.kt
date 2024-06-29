package com.david.glez.firebasecourse.advancedrealtimedatabse.ui.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.GetMessageUseCase
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.SendMessageUseCase
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.model.MessageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase,
    private val getMessageUseCase: GetMessageUseCase
) :
    ViewModel() {

    init {
        getMessage()
    }

    private var _messageList = MutableStateFlow<List<MessageModel>>(emptyList())
    val messageList: StateFlow<List<MessageModel>> = _messageList

    private fun getMessage() {
        viewModelScope.launch {
            getMessageUseCase().collect { messageModelList ->
                Log.d("ModelList", messageModelList.toString())
                _messageList.value = messageModelList
            }
        }
    }

    fun sendMessage() {
        val message = "Hello"
        sendMessageUseCase(message)
    }
}