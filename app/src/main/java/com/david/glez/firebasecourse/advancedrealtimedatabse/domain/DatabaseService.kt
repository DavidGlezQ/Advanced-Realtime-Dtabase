package com.david.glez.firebasecourse.advancedrealtimedatabse.domain

import kotlinx.coroutines.flow.Flow

interface DatabaseService {
    suspend fun clear()
    suspend fun saveUserName(nickname: String)
    fun getUserName(): Flow<String>
}