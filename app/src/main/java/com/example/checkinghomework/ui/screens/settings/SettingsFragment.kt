package com.example.checkinghomework.ui.screens.settings

import android.os.Bundle
import android.view.View
import com.example.checkinghomework.databinding.FragmentSettingsBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    override fun getViewBinding(): FragmentSettingsBinding =
        FragmentSettingsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarIconClick()
    }

    private fun setToolbarIconClick() {
        binding.toolbar.setOnClickListener {
            tryGoBack()
        }
    }

}