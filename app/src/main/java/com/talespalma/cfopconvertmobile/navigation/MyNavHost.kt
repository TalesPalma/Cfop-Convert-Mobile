package com.talespalma.cfopconvertmobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.talespalma.cfopconvertmobile.database.AppDatabase

@Composable
fun MyNavHost(modifier: Modifier = Modifier, db: AppDatabase) {
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = RoutesNav.Home.name
    ) {
        myNavGraph(navController, db)
    }
}