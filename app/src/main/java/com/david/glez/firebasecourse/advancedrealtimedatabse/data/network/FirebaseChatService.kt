package com.david.glez.firebasecourse.advancedrealtimedatabse.data.network

import com.google.firebase.database.DatabaseReference
import javax.inject.Inject

class FirebaseChatService @Inject constructor(private val reference: DatabaseReference) {
    companion object {
        private const val PATH = "messages"
    }
    fun sedMsgToFirebase(msg: String) {
        val newMsg = reference.child(PATH).push()
        newMsg.setValue(msg)
    }
}