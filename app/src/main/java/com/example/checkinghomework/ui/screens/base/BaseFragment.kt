package com.example.checkinghomework.ui.screens.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.checkinghomework.navigation.Navigator
import javax.inject.Inject

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    @Inject lateinit var navigator: Navigator

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }

    abstract fun getViewBinding(): VB

    override fun onResume() {
        super.onResume()
        navigator.setNavController(findNavController())
    }

    open fun tryGoBack() {
        navigator.goBack()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}