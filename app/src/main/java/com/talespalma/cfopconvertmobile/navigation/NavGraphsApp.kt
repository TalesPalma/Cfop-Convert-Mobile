package com.talespalma.cfopconvertmobile.navigation

import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.ui.contact.ContactScreen
import com.talespalma.cfopconvertmobile.ui.home.Home
import com.talespalma.cfopconvertmobile.ui.home.HomeViewModel

fun NavGraphBuilder.myNavGraph(
    database: AppDatabase,
    modifier: Modifier
) {
    val homeViewModel: HomeViewModel = HomeViewModel(database)
    composable(RoutesNav.Home.name) {
        Home(modifier = modifier)
    }
    composable(RoutesNav.Contact.name) {
        ContactScreen(name = "Tales", modifier = modifier)
    }
}