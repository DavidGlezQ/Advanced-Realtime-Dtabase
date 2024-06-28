package com.david.glez.firebasecourse.advancedrealtimedatabse.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.david.glez.firebasecourse.advancedrealtimedatabse.R
import com.david.glez.firebasecourse.advancedrealtimedatabse.databinding.FragmentChatBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val viewModel by viewModels<ChatViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.actionBack_chatFragment_to_mainFragment)
        }
        binding.btnSendMsg.setOnClickListener { viewModel.sendMessage() }
        return binding.root
    }
}