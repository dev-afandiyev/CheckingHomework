package com.example.checkinghomework.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.checkinghomework.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor() : INavigator {

    private var navController: NavController? = null
    private var navOptions: NavOptions? = null

    override fun setNavController(navController: NavController) {
        this.navController = navController

        navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in)
            .setExitAnim(R.anim.fade_out)
            .setPopEnterAnim(R.anim.fade_in)
            .setExitAnim(R.anim.slide_out)
            .build()
    }

    override fun open(screen: Int) {
        try {
//            navController?.navigate(screen)
            navController?.navigate(screen, null, navOptions)
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
    }

    override fun goBack() {
        if (navController?.previousBackStackEntry?.destination != null) {
            navController?.popBackStack()
        }
    }

}