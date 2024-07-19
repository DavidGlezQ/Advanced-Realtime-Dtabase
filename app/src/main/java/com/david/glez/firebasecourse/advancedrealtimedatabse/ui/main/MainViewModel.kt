package com.david.glez.firebasecourse.advancedrealtimedatabse.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val saveUserNameUseCase: SaveUserNameUseCase): ViewModel() {
    fun saveNickName(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserNameUseCase(userName)
        }
    }
}