package com.example.checkinghomework.ui.screens.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.checkinghomework.databinding.FragmentProfileBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import com.example.checkinghomework.ui.screens.profile.adapter.ProfileAdapter
import com.example.checkinghomework.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun getViewBinding(): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater)

    @Inject lateinit var profileAdapter: ProfileAdapter

    private val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        profileAdapter.loadCard(viewModel.getItem())
    }

    private fun initAdapter() {
        profileAdapter = ProfileAdapter()
        binding.profileSelection.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.profileSelection.adapter = profileAdapter
    }

}