package com.david.glez.firebasecourse.advancedrealtimedatabse.domain

import android.icu.util.Calendar
import com.david.glez.firebasecourse.advancedrealtimedatabse.data.network.FirebaseChatService
import com.david.glez.firebasecourse.advancedrealtimedatabse.data.network.dto.MessageDto
import com.david.glez.firebasecourse.advancedrealtimedatabse.data.network.dto.UserDto
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(private val firebaseChatService: FirebaseChatService) {

    operator fun invoke(message: String) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val min = calendar.get(Calendar.MINUTE)

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val userDto = UserDto(userName = "David", admin = true)

        val messageDto =
            MessageDto(
                message = message,
                hour = "$hour:$min",
                date = "$day/$month/$year",
                user = userDto
            )

        firebaseChatService.sedMsgToFirebase(messageDto = messageDto)
    }
}