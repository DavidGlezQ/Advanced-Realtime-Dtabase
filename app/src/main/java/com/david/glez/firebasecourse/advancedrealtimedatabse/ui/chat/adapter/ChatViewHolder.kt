package com.david.glez.firebasecourse.advancedrealtimedatabse.ui.chat.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.david.glez.firebasecourse.advancedrealtimedatabse.databinding.ItemChatMeBinding
import com.david.glez.firebasecourse.advancedrealtimedatabse.databinding.ItemChatOtherBinding
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.model.MessageModel

class ChatViewHolder(private val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(messageModel: MessageModel, itemViewType: Int) {
        when (itemViewType) {
            ChatAdapter.SENT_MESSAGE -> bindSentMessage(messageModel)
            ChatAdapter.RECEIVED_MESSAGE -> bindReceivedMessage(messageModel)
        }
    }

    private fun bindReceivedMessage(messageModel: MessageModel) {
        val currentBinding = binding as ItemChatOtherBinding
        currentBinding.tvDate.text = messageModel.date
        currentBinding.tvChat.text = messageModel.message
        currentBinding.tvName.text = messageModel.user.userName
        currentBinding.tvHour.text = messageModel.hour
    }

    private fun bindSentMessage(messageModel: MessageModel) {
        val currentBinding = binding as ItemChatMeBinding
        currentBinding.tvChatMe.text = messageModel.message
        currentBinding.tvDateMe.text = messageModel.date
        currentBinding.tvHour.text = messageModel.hour
    }
}
