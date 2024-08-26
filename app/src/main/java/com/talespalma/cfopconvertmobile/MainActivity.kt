package com.talespalma.cfopconvertmobile

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.ui.theme.CfopConvertMobileTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = AppDatabase.getInstance(applicationContext)

        CoroutineScope(Dispatchers.IO).launch {
            val result = db.cfopConsumoDao().getAll()
            Log.i("DATABASE_TESTE",result.toString())
        }


        setContent {
            CfopConvertMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                            Home(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}


@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(30.dp)){
        Text(text = "Versão cfop convert mobile")
    }
}


@Preview(device = "id:pixel_5", showSystemUi = true)
@Composable
private fun HomePreview() {
    CfopConvertMobileTheme {
        Home()
    }
}



