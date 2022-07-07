package com.example.checkinghomework.ui.screens.profile

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.viewModels
import com.example.checkinghomework.R
import com.example.checkinghomework.databinding.FragmentProfileBinding
import com.example.checkinghomework.ui.activity.MainActivity
import com.example.checkinghomework.ui.custom.CustomAlertDialog
import com.example.checkinghomework.ui.screens.base.BaseFragment
import com.example.checkinghomework.ui.screens.profile.viewpager.ViewPagerAdapter
import com.example.checkinghomework.viewmodel.ProfileViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun getViewBinding(): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater)

    private val viewModel: ProfileViewModel by viewModels()
    @Inject lateinit var alert: CustomAlertDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
        setTabLayout()
        setToolbar()
        setSideBarNavigation()
        setOnBackPressed()
        setUserData()
    }

    private fun setUserData() {
        viewModel.getAllItem()?.observe(viewLifecycleOwner) {
            it?.let {
                setSideBarData(it.username, it.email)
            }
        }
    }

    private fun setSideBarData(name: String, email: String) {
        val sideBarHeader = binding.navView.getHeaderView(0)
        sideBarHeader.findViewById<TextView>(R.id.sidebar_name).also {
            it.text = name
        }
        sideBarHeader.findViewById<TextView>(R.id.sidebar_email).also {
            it.text = email
        }
    }

    // TODO: fix
    private fun setSideBarNavigation() {
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_info -> alert.showDialog(this)
            }
            true
        }
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

    private fun setToolbar() {
        (requireActivity() as MainActivity).setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(
            requireActivity(),
            binding.drawer,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun setViewPager() {
        binding.viewPager.adapter =
            ViewPagerAdapter(
                requireActivity().supportFragmentManager,
                lifecycle
            )
    }

}