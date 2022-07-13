package com.example.checkinghomework.ui.screens.home

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentHomeBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import com.example.checkinghomework.ui.screens.home.viewpager.HomeViewPagerAdapter
import com.example.checkinghomework.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimation()
        setViewPager()
        checkUserData()
    }

    private fun checkUserData() {
        viewModel.getAllItem()?.observe(viewLifecycleOwner) {
            it?.let {
                if (it.username.isEmpty()) pagerNextItem() else
                    navigator.open(R.id.profileFragment)
            } ?: run { pagerNextItem() }
        }
    }

    private fun pagerNextItem() {
        binding.homeViewPager.let {
            it.currentItem = it.currentItem + 1
        }
    }

    private fun setViewPager() {
        binding.homeViewPager.isUserInputEnabled = false
        binding.homeViewPager.adapter =
            HomeViewPagerAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
    }

    private fun setupAnimation() {
        val animationDrawable = binding.homeLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }

}