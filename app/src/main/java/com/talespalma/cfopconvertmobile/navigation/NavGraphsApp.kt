package com.talespalma.cfopconvertmobile.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.ui.contact.ContactScreen
import com.talespalma.cfopconvertmobile.ui.home.Home

fun NavGraphBuilder.myNavGraph(
    navController: NavHostController,
    database: AppDatabase,
    modifier: Modifier
) {
    composable(RoutesNav.Home.name) {
        Home(db = database, navController = navController, modifier = modifier)
    }
    composable(RoutesNav.Contact.name) {
        ContactScreen(name = "Tales", modifier = modifier)
    }
}