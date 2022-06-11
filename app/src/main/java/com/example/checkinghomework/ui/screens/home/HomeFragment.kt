package com.example.checkinghomework.ui.screens.home

import android.os.Bundle
import android.view.View
import com.example.checkinghomework.databinding.FragmentHomeBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}