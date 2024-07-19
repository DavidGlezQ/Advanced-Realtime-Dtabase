package com.david.glez.firebasecourse.advancedrealtimedatabse.domain

interface DatabaseService {
    suspend fun saveUserName(nickname: String)
}