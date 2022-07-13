package com.example.checkinghomework.ui.screens.splash

import com.example.checkinghomework.databinding.FragmentSplashBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun getViewBinding(): FragmentSplashBinding =
        FragmentSplashBinding.inflate(layoutInflater)

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }

}