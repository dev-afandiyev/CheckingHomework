package com.example.checkinghomework.ui.screens.about

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentAboutFirstBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFirstFragment : BaseFragment<FragmentAboutFirstBinding>() {

    override fun getViewBinding(): FragmentAboutFirstBinding =
        FragmentAboutFirstBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNextButton()
    }

    private fun setNextButton() {
        val homeViewPager = requireActivity().findViewById<ViewPager2>(R.id.home_view_pager)

        binding.nextBtn.setOnClickListener {
            homeViewPager.currentItem = homeViewPager.currentItem + 1
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }

}