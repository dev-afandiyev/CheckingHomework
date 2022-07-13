package com.example.checkinghomework.ui.screens.home.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.checkinghomework.ui.screens.about.AboutFirstFragment
import com.example.checkinghomework.ui.screens.about.AboutSecondFragment
import com.example.checkinghomework.ui.screens.splash.SplashFragment

class HomeViewPagerAdapter(
    manager: FragmentManager,
    lifecycleOwner: Lifecycle
) : FragmentStateAdapter(manager, lifecycleOwner) {

    private val items: ArrayList<Fragment> = arrayListOf(
        SplashFragment(),
        AboutFirstFragment(),
        AboutSecondFragment()
    )

    override fun getItemCount(): Int = items.size

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }

}