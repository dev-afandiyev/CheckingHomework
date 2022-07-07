package com.example.checkinghomework.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections

interface INavigator {

    fun setNavController(navController: NavController)

    fun open(screen: Int)

    fun open(navDirections: NavDirections)

    fun goBack()

}