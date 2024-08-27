package com.talespalma.cfopconvertmobile

import android.annotation.SuppressLint
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.database.entitys.CfopConsumo
import com.talespalma.cfopconvertmobile.ui.theme.CfopConvertMobileTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = AppDatabase.getInstance(applicationContext)
        setContent {
            CfopConvertMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Home(modifier = Modifier.padding(padding), db)
                }
            }
        }
    }
}


@Composable
fun Home(modifier: Modifier = Modifier, db: AppDatabase?) {
    val cfopConsumo : SnapshotStateList<CfopConsumo> = remember { mutableStateListOf() }
    Column(modifier = Modifier.padding(30.dp)) {
        LaunchedEffect(Unit){
            val cfops : Flow<List<CfopConsumo>>? = db?.cfopConsumoDao()?.getAll()
            cfops?.collect{
                cfopConsumo.addAll(it)
            }
        }
        cfopConsumo.forEach{
            Text(text = it.code)
        }
    }
}


@Preview(device = "id:pixel_5", showSystemUi = true)
@Composable
private fun HomePreview() {
    CfopConvertMobileTheme {
        Home(db = null)
    }
}



