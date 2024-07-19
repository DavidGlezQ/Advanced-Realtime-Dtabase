package com.david.glez.firebasecourse.advancedrealtimedatabse.ui.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.GetMessageUseCase
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.GetUserNameUseCase
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.LogoutUseCase
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.SendMessageUseCase
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.model.MessageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase,
    private val getMessageUseCase: GetMessageUseCase,
    private val getUserNameUseCase: GetUserNameUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {

    var name: String = ""

    init {
        getUserName()
        getMessage()
    }

    private fun getUserName() {
        viewModelScope.launch(Dispatchers.IO) {
            name = getUserNameUseCase()
        }
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

    fun sendMessage(message: String) {
        sendMessageUseCase(message = message, userName = name)
    }

    fun logout(onViewFinish:() -> Unit) {
        viewModelScope.launch {
            async {
                logoutUseCase()
            }.await()
            onViewFinish()
        }
    }
}