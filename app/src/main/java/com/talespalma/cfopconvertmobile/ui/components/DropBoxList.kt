package com.talespalma.cfopconvertmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.talespalma.cfopconvertmobile.ui.home.HomeScreenState
import com.talespalma.cfopconvertmobile.ui.home.HomeViewModel

@Composable
fun DropBoxList(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    uiState: HomeScreenState
) {
    Box(modifier = Modifier.padding(30.dp)) {
        Text(
            text = "Selecione o CFOP",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { homeViewModel.updateExpanded(true) }
                .background(color = Color.Cyan)
                .padding(16.dp)
        )
        DropdownMenu(expanded = uiState.expanded, onDismissRequest = { homeViewModel.updateExpanded(false) }) {
            uiState.cfops.forEach { cfop ->
                DropdownMenuItem(
                    text = { Text(text = cfop.code) },
                    onClick = {
                        homeViewModel.updateCfopSelected(cfop.code)
                        homeViewModel.updateCfopConvetido(cfop.covertindCode)
                        homeViewModel.updateExpanded(false)
                    }
                )
            }
        }
    }
    Text(text = "Selecionado:${uiState.cfopSelected} ${uiState.cfopConvetido}")
}
