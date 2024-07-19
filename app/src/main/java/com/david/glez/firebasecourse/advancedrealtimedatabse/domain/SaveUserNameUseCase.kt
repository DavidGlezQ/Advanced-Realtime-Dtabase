package com.david.glez.firebasecourse.advancedrealtimedatabse.domain

import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor(private val databaseService: DatabaseService) {

    suspend operator fun invoke(userName: String) {
        databaseService.saveUserName(nickname = userName)
    }
}