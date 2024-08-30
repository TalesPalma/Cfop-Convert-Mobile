package com.talespalma.cfopconvertmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.talespalma.cfopconvertmobile.navigation.RoutesNav
import com.talespalma.cfopconvertmobile.navigation.myNavGraph

@Composable
fun SideMenuNavigation(modifier: Modifier = Modifier, navHostController: NavController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val pages = listOf(
        RoutesNav.Home,
        RoutesNav.Contact
    )
    val icons = listOf(Icons.Filled.Home, Icons.Filled.AccountCircle)
    Row(
        modifier = modifier
    ){
        NavigationRail(
            containerColor = Color.DarkGray,
            modifier = Modifier.clip(RoundedCornerShape(20.dp))
        ){
            pages.forEachIndexed { index, item ->
                when (item) {
                    RoutesNav.Home -> {
                        NavigationRailItem(
                            icon = { Icon(icons[index], contentDescription = "Home" , tint = Color.Black) },
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
                                navHostController.navigate(RoutesNav.Home.name)
                            }
                        )
                    }

                    RoutesNav.Contact -> {
                        NavigationRailItem(
                            icon = { Icon(icons[index], contentDescription = "Contact", tint = Color.Black) },
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
                                navHostController.navigate(RoutesNav.Contact.name)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSideMenuNavigation() {
    SideMenuNavigation(navHostController = mockNavController())
}

@Composable
fun mockNavController()  : NavController{
    val navController = rememberNavController()
    return navController
}

