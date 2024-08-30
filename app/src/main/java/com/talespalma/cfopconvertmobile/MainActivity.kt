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
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.navigation.MyNavHost
import com.talespalma.cfopconvertmobile.ui.components.SideMenuNavigation
import com.talespalma.cfopconvertmobile.ui.theme.CfopConvertMobileTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CfopConvertMobileTheme {
                InitApp(db = db)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InitApp(db: AppDatabase) {
    val navController = rememberNavController()
    Scaffold(topBar = {
        TopAppBar(title = { Text("Cfop Concert App") }, navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        })
    }) { padding ->
        SideMenuNavigation(navHostController = navController, modifier = Modifier.padding(padding))
        MyNavHost(db = db, navController = navController, modifier = Modifier.padding(padding))
    }
}





















