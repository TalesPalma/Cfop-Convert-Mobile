package com.talespalma.cfopconvertmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.ui.home.Home
import com.talespalma.cfopconvertmobile.ui.theme.CfopConvertMobileTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CfopConvertMobileTheme {
                MainScreen(db = db)
            }
        }
    }
}


@Composable
fun MainScreen(modifier: Modifier = Modifier, db:AppDatabase) {
    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        Home(modifier = Modifier.padding(padding), db = db)
    }
}










