package com.example.checkinghomework.ui.screens.home

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import com.example.checkinghomework.databinding.FragmentHomeBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animationStart()
    }

    private fun animationStart() {
        val animationDrawable = binding.homeLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

}