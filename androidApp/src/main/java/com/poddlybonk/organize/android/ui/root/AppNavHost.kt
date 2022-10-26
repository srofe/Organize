package com.poddlybonk.organize.android.ui.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.poddlybonk.organize.android.ui.about.AboutView
import com.poddlybonk.organize.android.ui.reminders.RemindersView
import com.poddlybonk.organize.presentation.Screen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Reminders.route,
        modifier = modifier
    ) {
        composable(Screen.Reminders.route) {
            RemindersView(
                onAboutButtonClick = { navController.navigate(Screen.AboutDevice.route) }
            )
        }
        composable(Screen.AboutDevice.route) {
            AboutView(
                onUpButtonClick = { navController.popBackStack() }
            )
        }
    }
}
