package com.example.checkinghomework.ui.screens.videos

import android.os.Bundle
import android.view.View
import com.example.checkinghomework.databinding.FragmentVideosBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosFragment : BaseFragment<FragmentVideosBinding>() {

    override fun getViewBinding(): FragmentVideosBinding =
        FragmentVideosBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}