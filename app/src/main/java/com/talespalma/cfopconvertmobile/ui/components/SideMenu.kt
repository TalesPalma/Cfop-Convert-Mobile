package com.talespalma.cfopconvertmobile.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.talespalma.cfopconvertmobile.navigation.RoutesNav

@Composable
fun SideMenuNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavController,
    closeMenu: () -> Unit = {}
) {
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
            containerColor = Color( 0xFF, 0xFF, 0xFF).copy(alpha = 0.10F),
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
                                closeMenu()
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
                                closeMenu()
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

