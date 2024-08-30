package com.talespalma.cfopconvertmobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.talespalma.cfopconvertmobile.navigation.MyNavHost
import com.talespalma.cfopconvertmobile.ui.components.SideMenuNavigation
import com.talespalma.cfopconvertmobile.ui.theme.CfopConvertMobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CfopConvertMobileTheme {
                InitApp()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InitApp() {
    val navController = rememberNavController()
    var isVisible by remember { mutableStateOf(false) }
    Scaffold(topBar = {
        TopAppBar(title = { Text("Cfop Concert App") }, navigationIcon = {
            IconButton(onClick = {isVisible = !isVisible}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        })
    }) { padding ->
        if (isVisible){
            SideMenuNavigation(navHostController = navController, modifier = Modifier.padding(padding))
        }
        MyNavHost(navController = navController, modifier = Modifier.padding(padding))
    }
}





















