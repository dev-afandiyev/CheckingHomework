package com.example.checkinghomework.ui.screens.about

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentAboutSecondBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutSecondFragment : BaseFragment<FragmentAboutSecondBinding>() {

    override fun getViewBinding(): FragmentAboutSecondBinding =
        FragmentAboutSecondBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtons()
    }

    private fun setButtons() {
        val homeViewPager = requireActivity().findViewById<ViewPager2>(R.id.home_view_pager)

        binding.prevBtn.setOnClickListener {
            homeViewPager.currentItem = homeViewPager.currentItem - 1
        }

        binding.finishBtn.setOnClickListener {
            navigator.open(R.id.loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }

}