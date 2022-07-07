package com.example.checkinghomework.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.example.checkinghomework.databinding.ActivityMainBinding
import com.example.checkinghomework.ui.activity.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.checkinghomework.R
import com.example.checkinghomework.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun getViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        supportActionBar?.hide()

        val navController: NavController = Navigation.findNavController(this, R.id.fv_container)
        val navGraph = navController.navInflater.inflate(R.navigation.screens_navigation)

        mainViewModel.getAllItem()?.observe(this) {
            it?.let {
                if (it.username.isNotEmpty() && it.password.isNotEmpty()) {
                    navGraph.setStartDestination(R.id.profileFragment)
                    navController.graph = navGraph
                }
            }
        }
    }

}
