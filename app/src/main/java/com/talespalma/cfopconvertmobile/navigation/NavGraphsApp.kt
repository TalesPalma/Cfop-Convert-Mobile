package com.talespalma.cfopconvertmobile.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.ui.contact.ContactScreen
import com.talespalma.cfopconvertmobile.ui.home.Home

fun NavGraphBuilder.myNavGraph(navController: NavHostController, database: AppDatabase) {
    composable(RoutesNav.Home.name) {
        Home(db = database, navController = navController)
    }
    composable(RoutesNav.Contact.name+"/{name}") {
        val name = it.arguments?.getString("name")
        ContactScreen(navController = navController, name = name)
    }
}