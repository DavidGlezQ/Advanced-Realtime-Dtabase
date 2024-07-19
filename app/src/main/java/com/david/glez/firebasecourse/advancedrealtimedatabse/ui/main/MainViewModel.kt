package com.david.glez.firebasecourse.advancedrealtimedatabse.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.GetUserNameUseCase
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
) :
    ViewModel() {

    init {
        verifyUserLogged()
    }

    private var _iuState = MutableStateFlow<MainViewState>(MainViewState.LOADING)
    val iuState: StateFlow<MainViewState> = _iuState

    private fun verifyUserLogged() {
        viewModelScope.launch {
            val name = getUserNameUseCase()
            if (name.isNotEmpty()) {
                _iuState.value = MainViewState.REGISTERED
            } else {
                _iuState.value = MainViewState.UNREGISTERED
            }
        }
    }

    fun saveNickName(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserNameUseCase(userName)
        }
    }
}

sealed class MainViewState {
    object UNREGISTERED: MainViewState()
    object REGISTERED: MainViewState()
    object LOADING: MainViewState()
}