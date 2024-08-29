package com.talespalma.cfopconvertmobile.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.talespalma.cfopconvertmobile.database.AppDatabase
import com.talespalma.cfopconvertmobile.models.Cfop
import com.talespalma.cfopconvertmobile.ui.theme.CfopConvertMobileTheme

@Composable
fun Home(modifier: Modifier = Modifier, db: AppDatabase?, navController: NavController?) {

    var categorySelected by remember { mutableIntStateOf(1) }
    val cfops: SnapshotStateList<Cfop> = remember { mutableStateListOf() }
    Column(modifier = Modifier.padding(30.dp)) {
        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .align(Alignment.End)
        ) {
            Row {
                RadioButton(onClick = { categorySelected = 1 }, selected = (categorySelected == 1))
                Text("Cfop Consumo")
            }
            Row {
                RadioButton(onClick = { categorySelected = 2 }, selected = (categorySelected == 2))
                Text("Cfop Revenda")
            }
            Row {
                RadioButton(onClick = { categorySelected = 3 }, selected = (categorySelected == 3))
                Text("Cfop Industrializacao")
            }
        }





        LaunchedEffect(categorySelected) {
            when (categorySelected) {
                1 -> db?.cfopConsumoDao()?.getAll()?.collect {
                    cfops.clear()
                    for (cfop in it) {
                        cfops.add(
                            Cfop(
                                code = cfop.code,
                                covertindCode = cfop.converting
                            )
                        )
                    }
                }

                2 -> db?.cfopRevendaDao()?.getAll()?.collect {
                    cfops.clear()
                    for (cfop in it) {
                        cfops.add(
                            Cfop(
                                code = cfop.code,
                                covertindCode = cfop.converting
                            )
                        )
                    }
                }

                3 -> db?.cfopIndustrializacaoDao()?.getAll()?.collect {
                    cfops.clear()
                    for (cfop in it) {
                        cfops.add(
                            Cfop(
                                code = cfop.code,
                                covertindCode = cfop.converting
                            )
                        )
                    }
                }
            }
        }

        var expanded by remember { mutableStateOf(false) }
        var cfopSelected by remember { mutableStateOf("") }
        var cfopConvetido by remember { mutableStateOf("") }
        Box(modifier = Modifier.padding(30.dp)) {
            Text(
                text = "Selecione o CFOP",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true }
                    .background(color = Color.Cyan)
                    .padding(16.dp)
            )
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                cfops.forEach { cfop ->
                    DropdownMenuItem(
                        text = { Text(text = cfop.code) },
                        onClick = {
                            cfopSelected = cfop.code
                            cfopConvetido = cfop.covertindCode
                            expanded = false
                        }
                    )
                }
            }
        }
        Text(text = "Selecionado:$cfopSelected $cfopConvetido")
    }

}






@Preview(showSystemUi = true)
@Composable
private fun HomePreview() {
    CfopConvertMobileTheme {
        Home(db = null, navController = null)
    }
}