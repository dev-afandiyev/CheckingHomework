package com.example.checkinghomework.ui.screens.profile

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import com.example.checkinghomework.databinding.FragmentProfileBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import com.example.checkinghomework.ui.screens.profile.viewpager.ViewPagerAdapter
import com.example.checkinghomework.viewmodel.ProfileViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val viewModel: ProfileViewModel by viewModels()

    override fun getViewBinding(): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
        setTabLayout()
        setOnBackPressed()
    }

    // TODO: fix
    private fun setOnBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (binding.viewPager.currentItem > 0) {
                binding.viewPager.currentItem = binding.viewPager.currentItem - 1
            }
        }
    }

    private fun setTabLayout() {
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->
            tab.text = viewModel.setTabTitle(position)
        }.attach()
    }

    private fun setViewPager() {
        binding.viewPager.adapter =
            ViewPagerAdapter(
                requireActivity().supportFragmentManager,
                lifecycle
            )
    }

}