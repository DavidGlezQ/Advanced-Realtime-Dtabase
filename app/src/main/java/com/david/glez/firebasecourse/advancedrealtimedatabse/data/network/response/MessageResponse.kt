package com.david.glez.firebasecourse.advancedrealtimedatabse.data.network.response

import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.model.MessageModel
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.model.UserModel

data class MessageResponse(
    val message: String? = null,
    val hour: String? = null,
    val date: String? = null,
    val user: UserResponse? = null
) {
    fun toDomain(): MessageModel {
        return MessageModel(
            message = message ?: "", // ?: ""
            hour = hour ?: "no date",
            date = date.orEmpty(),
            user = UserModel(
                userName = user?.userName ?: "Guess",
                admin = user?.admin ?: false
            )
        )
    }
}

data class UserResponse(val userName: String? = null, val admin: Boolean ? = null)
