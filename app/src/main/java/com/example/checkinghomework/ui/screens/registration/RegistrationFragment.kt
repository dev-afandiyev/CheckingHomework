package com.example.checkinghomework.ui.screens.registration

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import com.example.checkinghomework.databinding.FragmentRegistrationBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {

    override fun getViewBinding(): FragmentRegistrationBinding =
        FragmentRegistrationBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimation()

        binding.button.setOnClickListener {
            binding.button.setLoading(true)
        }

        binding.logInTextButton.setOnClickListener {

        }
    }

    private fun setupAnimation() {
        val animationDrawable = binding.registrationLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

}