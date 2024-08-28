package com.talespalma.cfopconvertmobile.navigation


sealed class RoutesNav(val name: String) {
    data object Home : RoutesNav(name = "HomeRoute")
    data object Contact : RoutesNav(name = "ContactRoute")
}



