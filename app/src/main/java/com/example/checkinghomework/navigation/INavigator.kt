package com.example.checkinghomework.navigation

import androidx.navigation.NavController

interface INavigator {

    fun setNavController(navController: NavController)

    fun open(screen: Int)

    fun goBack()

}