package com.talespalma.cfopconvertmobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.talespalma.cfopconvertmobile.database.AppDatabase

@Composable
fun MyNavHost(modifier: Modifier = Modifier,navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = RoutesNav.Home.name
    ) {
        myNavGraph(modifier)
    }
}