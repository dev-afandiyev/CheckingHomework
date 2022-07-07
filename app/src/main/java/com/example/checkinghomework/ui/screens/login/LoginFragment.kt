package com.example.checkinghomework.ui.screens.login

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentLoginBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import com.example.checkinghomework.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override fun getViewBinding(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimation()

        viewModel.logPassState.observe(viewLifecycleOwner) {
            binding.nameInput.setText(it.email)
            binding.password.setText(it.password)
        }

        binding.button.setOnClickListener {
            val userName = binding.nameInput.text.toString()
            val password = binding.password.text.toString()

            val logPass = viewModel.getByLogin(userName, password)
            if (logPass != null) {
                binding.button.setLoading(true)
                navigator.open(R.id.profileFragment)
            }
        }

        loginListener()
    }

    private fun loginListener() {
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

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }
}