package com.example.checkinghomework.ui.screens.registration

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.fragment.app.viewModels
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentRegistrationBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import com.example.checkinghomework.viewmodels.RegistrationViewModel
import com.jakewharton.rxbinding3.widget.textChanges
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun getViewBinding(): FragmentRegistrationBinding =
        FragmentRegistrationBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimation()
        setupSignUpButton()
        setupLogInButton()
        formValidation()
    }

    private fun formValidation() {
        val nameField = binding.nameInput.textChanges()
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                binding.nameInputLayout.error =
                    if (it.length > 3) null else "Min 3 characters"
                it.isNotBlank() && it.length > 3
            }

        val emailField = binding.emailInput.textChanges()
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                binding.emailInputLayout.error =
                    if (Patterns.EMAIL_ADDRESS.matcher(it).matches()) null else "Invalid email"
                it.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(it).matches()
            }

        val passField = binding.passwordInput.textChanges()
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                binding.passInputLayout.error =
                    if (it.length > 6) null else "Min 6 characters"
                it.isNotBlank() && it.length > 6
            }

        // todo: fix
        val passAgainField = binding.passwordInput.textChanges()
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                binding.passwordInput.text == binding.passwordAgainInput.text
            }

        viewModel.validation(nameField, emailField, passField, passAgainField)
    }

    private fun setupSignUpButton() {
        binding.button.setOnClickListener {
            binding.button.setLoading(true)
            navigator.open(R.id.profileFragment)
        }

        viewModel.getButtonLiveState().observe(viewLifecycleOwner) {
            binding.button.isEnabled = it
        }
    }

    private fun setupLogInButton() {
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

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }

}