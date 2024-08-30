package com.talespalma.cfopconvertmobile.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.talespalma.cfopconvertmobile.ui.contact.ContactScreen
import com.talespalma.cfopconvertmobile.ui.home.Home

fun NavGraphBuilder.myNavGraph(
    modifier: Modifier
) {
    composable(RoutesNav.Home.name) {
        Home(modifier = modifier)
    }
    composable(RoutesNav.Contact.name) {
        ContactScreen(name = "Tales", modifier = modifier)
    }
}