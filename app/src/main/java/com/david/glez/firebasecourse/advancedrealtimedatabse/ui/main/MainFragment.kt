package com.david.glez.firebasecourse.advancedrealtimedatabse.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.david.glez.firebasecourse.advancedrealtimedatabse.R
import com.david.glez.firebasecourse.advancedrealtimedatabse.databinding.FragmentChatBinding
import com.david.glez.firebasecourse.advancedrealtimedatabse.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.btnChat.setOnClickListener {
            if (binding.tieName.text.isNullOrBlank())
                findNavController().navigate(R.id.action_mainFragment_to_chatFragment)
        }

        return binding.root
    }
}