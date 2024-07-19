package com.david.glez.firebasecourse.advancedrealtimedatabse.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.david.glez.firebasecourse.advancedrealtimedatabse.R
import com.david.glez.firebasecourse.advancedrealtimedatabse.databinding.FragmentChatBinding
import com.david.glez.firebasecourse.advancedrealtimedatabse.ui.chat.adapter.ChatAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val viewModel by viewModels<ChatViewModel>()

    private lateinit var chatAdapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.actionBack_chatFragment_to_mainFragment)
        }
        setUpUi()
        binding.btnSendMsg.setOnClickListener { viewModel.sendMessage() }
        return binding.root
    }

    private fun setUpUi() {
        setUpMessageList()
        subscribeToMessage()
    }

    private fun setUpMessageList() {
        chatAdapter = ChatAdapter(mutableListOf())
        binding.rvMsg.apply {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun subscribeToMessage() {
        lifecycleScope.launch {
            viewModel.messageList.collect {
                chatAdapter.updateList(it.toMutableList(), name = viewModel.name)
                binding.rvMsg.scrollToPosition(chatAdapter.messageList.size - 1)
            }
        }
    }
}