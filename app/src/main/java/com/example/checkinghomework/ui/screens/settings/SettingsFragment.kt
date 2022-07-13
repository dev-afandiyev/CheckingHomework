package com.example.checkinghomework.ui.screens.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentSettingsBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import com.example.checkinghomework.viewmodels.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    private val viewModel: SettingsViewModel by viewModels()

    override fun getViewBinding(): FragmentSettingsBinding =
        FragmentSettingsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
        setUserData()
        setLogOut()
    }

    // TODO: fix popBackStack
    private fun setLogOut() {
        binding.logOutBtn.setOnClickListener {
            navigator.open(R.id.loginFragment)
        }
    }

    private fun setUserData() {
        viewModel.getUserData()?.observe(viewLifecycleOwner) {
            it?.let {
                binding.userName.text = it.username
                binding.userEmail.text = it.email
            }
        }
    }

    private fun setToolbar() {
        binding.toolbar.setOnClickListener {
            tryGoBack()
        }
    }

}