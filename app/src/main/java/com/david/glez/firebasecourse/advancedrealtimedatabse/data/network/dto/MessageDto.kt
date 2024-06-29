package com.david.glez.firebasecourse.advancedrealtimedatabse.data.network.dto

data class MessageDto(
    val message: String,
    val hour: String,
    val date: String,
    val user: UserDto
)

data class UserDto(val userName: String, val admin: Boolean)
