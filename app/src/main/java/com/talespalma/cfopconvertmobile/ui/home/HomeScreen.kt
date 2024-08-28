package com.talespalma.cfopconvertmobile.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.database.entitys.CfopConsumo
import com.talespalma.cfopconvertmobile.ui.theme.CfopConvertMobileTheme
import kotlinx.coroutines.flow.Flow

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


@Preview(showSystemUi = true)
@Composable
private fun HomePreview() {
    CfopConvertMobileTheme {
        Home(db = null)
    }
}