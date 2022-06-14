package com.example.checkinghomework.ui.screens.registration

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentRegistrationBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import com.example.checkinghomework.viewmodel.RegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun getViewBinding(): FragmentRegistrationBinding =
        FragmentRegistrationBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimation()
        saveStateParam()
        setupRegistration()
        setupLogInText()
    }

    private fun saveStateParam() {
        viewModel.userState.observe(viewLifecycleOwner) {
            binding.nameInput.setText(it.username)
            binding.emailInput.setText(it.email)
            binding.passwordInput.setText(it.password)
        }
    }

    private fun setupRegistration() {
        binding.button.setOnClickListener {
            binding.button.setLoading(true)
            viewModel.insertParam(
                binding.nameInput.text.toString(),
                binding.emailInput.text.toString(),
                binding.passwordInput.text.toString(),
            )
            navigator.open(R.id.loginFragment)
        }
    }

    private fun setupLogInText() {
        binding.logInTextButton.setOnClickListener {
            navigator.open(R.id.loginFragment)
        }
    }

    private fun setupAnimation() {
        val animationDrawable = binding.registrationLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

}