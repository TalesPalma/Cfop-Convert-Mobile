package com.talespalma.cfopconvertmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.navigation.MyNavHost
import com.talespalma.cfopconvertmobile.navigation.RoutesNav
import com.talespalma.cfopconvertmobile.navigation.myNavGraph
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
                MyNavHost(db = db)
            }
        }
    }
}
















