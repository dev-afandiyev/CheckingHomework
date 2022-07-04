package com.example.checkinghomework.ui.screens.chat

import android.os.Bundle
import android.view.View
import com.example.checkinghomework.databinding.FragmentChatBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : BaseFragment<FragmentChatBinding>() {

    override fun getViewBinding(): FragmentChatBinding =
        FragmentChatBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}