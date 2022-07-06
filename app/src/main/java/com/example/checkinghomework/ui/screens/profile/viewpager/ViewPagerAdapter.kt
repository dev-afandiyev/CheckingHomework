package com.example.checkinghomework.ui.screens.profile.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.checkinghomework.ui.screens.chat.ChatFragment
import com.example.checkinghomework.ui.screens.news.NewsFragment
import com.example.checkinghomework.ui.screens.videos.VideosFragment
import javax.inject.Singleton

class ViewPagerAdapter(
    manager: FragmentManager,
    lifecycleOwner: Lifecycle
) : FragmentStateAdapter(manager, lifecycleOwner) {

    private val items: ArrayList<Fragment> = arrayListOf(
        NewsFragment(),
        VideosFragment(),
        ChatFragment()
    )

    override fun getItemCount(): Int = items.size

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }

}