package com.david.glez.firebasecourse.advancedrealtimedatabse.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.david.glez.firebasecourse.advancedrealtimedatabse.R
import com.david.glez.firebasecourse.advancedrealtimedatabse.databinding.FragmentChatBinding


class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.actionBack_chatFragment_to_mainFragment)
        }
        return binding.root
    }
}