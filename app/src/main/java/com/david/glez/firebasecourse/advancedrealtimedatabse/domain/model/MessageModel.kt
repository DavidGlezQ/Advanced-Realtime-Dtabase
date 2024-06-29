package com.david.glez.firebasecourse.advancedrealtimedatabse.domain.model

data class MessageModel(
    val message: String,
    val hour: String,
    val date: String,
    val user: UserModel
)

data class UserModel(val userName: String, val admin: Boolean)


