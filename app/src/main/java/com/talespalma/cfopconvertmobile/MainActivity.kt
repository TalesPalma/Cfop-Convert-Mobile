package com.talespalma.cfopconvertmobile

import android.os.Bundle
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
import com.talespalma.cfopconvertmobile.ui.theme.CfopConvertMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
    Column {
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



