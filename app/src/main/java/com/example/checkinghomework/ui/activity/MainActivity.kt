package com.example.checkinghomework.ui.activity

import android.os.Bundle
import com.example.checkinghomework.databinding.ActivityMainBinding
import com.example.checkinghomework.ui.activity.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        supportActionBar?.hide()
    }

}