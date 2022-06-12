package com.example.checkinghomework.navigation

import androidx.navigation.NavController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor() {

    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    fun open(screen: Int) {
        try {
            navController?.navigate(screen)
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
    }

    fun goBack() {
        if (navController?.previousBackStackEntry?.destination != null) {
            navController?.popBackStack()
        }
    }

}