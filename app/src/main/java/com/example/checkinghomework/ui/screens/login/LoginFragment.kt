package com.example.checkinghomework.ui.screens.login

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentLoginBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override fun getViewBinding(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimation()

        binding.button.setOnClickListener {
            binding.button.setLoading(true)
        }

        binding.signUpTextButton.setOnClickListener {
            navigator.open(R.id.registrationFragment)
        }
    }

    private fun setupAnimation() {
        val animationDrawable = binding.loginLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

}