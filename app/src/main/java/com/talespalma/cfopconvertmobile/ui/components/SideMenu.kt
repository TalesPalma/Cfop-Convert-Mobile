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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.talespalma.cfopconvertmobile.navigation.RoutesNav
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SideMenuNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavController,
    closeMenu: () -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()
    val pages = listOf(
        RoutesNav.Home,
        RoutesNav.Contact
    )
    val icons = listOf(Icons.Filled.Home, Icons.Filled.AccountCircle)
    Row(
        modifier = modifier
    ) {
        NavigationRail(
            containerColor = Color(0xFF, 0xFF, 0xFF).copy(alpha = 0.10F),
            modifier = Modifier.clip(RoundedCornerShape(20.dp))
        ) {
            pages.forEachIndexed { index, item ->
                NavigationRailItem(
                    icon = {
                        Icon(
                            icons[index],
                            contentDescription = item.name,
                            tint = Color.White
                        )
                    },
                    selected = false,
                    onClick = {
                        navHostController.navigate(item.name)
                        coroutineScope.launch {
                            delay(500)
                            closeMenu()
                        }
                    }
                )
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
fun mockNavController(): NavController {
    val navController = rememberNavController()
    return navController
}

