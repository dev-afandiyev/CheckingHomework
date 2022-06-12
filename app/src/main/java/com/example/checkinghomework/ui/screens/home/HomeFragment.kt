package com.example.checkinghomework.ui.screens.home

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentHomeBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimation()

        binding.button.setOnClickListener {
            binding.button.setLoading(true)
            navigator.open(R.id.loginFragment)
        }
    }

    private fun setupAnimation() {
        val animationDrawable = binding.homeLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

}