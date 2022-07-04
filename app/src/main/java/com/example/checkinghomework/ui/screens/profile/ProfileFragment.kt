package com.example.checkinghomework.ui.screens.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentProfileBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import com.example.checkinghomework.ui.screens.chat.ChatFragment
import com.example.checkinghomework.ui.screens.news.NewsFragment
import com.example.checkinghomework.ui.screens.profile.adapter.ProfileAdapter
import com.example.checkinghomework.ui.screens.videos.VideosFragment
import com.example.checkinghomework.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    @Inject
    lateinit var profileAdapter: ProfileAdapter
    private val viewModel: ProfileViewModel by viewModels()

    override fun getViewBinding(): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        profileAdapter.loadCard(viewModel.getItem())
    }

    private fun initAdapter() {
        profileAdapter = ProfileAdapter()
        binding.profileSelection.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.profileSelection.adapter = profileAdapter

        profileAdapter.setOnItemClickListener {
            screensNavigation(it)
        }
    }

    private fun screensNavigation(itemId: Int) {
        when (itemId) {
            0 -> swapFragments(NewsFragment())
            1 -> swapFragments(VideosFragment())
            2 -> swapFragments(ChatFragment())
        }
    }

    private fun swapFragments(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.profile_screens, fragment)
            .commit()
    }

}