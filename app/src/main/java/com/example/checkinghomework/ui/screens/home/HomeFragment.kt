package com.example.checkinghomework.ui.screens.home

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentHomeBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimation()
        Handler(Looper.getMainLooper()).postDelayed({
            binding.progressBarCyclic.visibility = View.GONE
            binding.button.visibility = View.VISIBLE
        }, 3000)

        binding.button.setOnClickListener {
            binding.button.setLoading(true)
            navigator.open(R.id.loginFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.progressBarCyclic.visibility = View.VISIBLE
        binding.button.visibility = View.GONE
    }

    private fun setupAnimation() {
        val animationDrawable = binding.homeLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

}