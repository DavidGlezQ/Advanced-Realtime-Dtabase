package com.david.glez.firebasecourse.advancedrealtimedatabse.data.network

import com.david.glez.firebasecourse.advancedrealtimedatabse.data.network.dto.MessageDto
import com.google.firebase.database.DatabaseReference
import javax.inject.Inject

class FirebaseChatService @Inject constructor(private val reference: DatabaseReference) {
    companion object {
        private const val PATH = "messages"
    }
    fun sedMsgToFirebase(messageDto: MessageDto) {
        val newMsg = reference.child(PATH).push()
        newMsg.setValue(messageDto)
    }
}