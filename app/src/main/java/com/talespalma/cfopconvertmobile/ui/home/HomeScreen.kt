package com.talespalma.cfopconvertmobile.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.talespalma.cfopconvertmobile.ui.components.DropBoxList
import com.talespalma.cfopconvertmobile.ui.theme.CfopConvertMobileTheme

@Composable
fun Home(
    modifier: Modifier = Modifier,
) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val uiState by homeViewModel.uiState.collectAsState()
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
        ) {
            Row {
                RadioButton(
                    onClick = { homeViewModel.updateCategory(1) },
                    selected = (uiState.categorySelected == 1)
                )
                Text("Cfop Consumo")
            }
            Row {
                RadioButton(
                    onClick = { homeViewModel.updateCategory(2) },
                    selected = (uiState.categorySelected == 2)
                )
                Text("Cfop Revenda")
            }
            Row {
                RadioButton(
                    onClick = { homeViewModel.updateCategory(3) },
                    selected = (uiState.categorySelected == 3)
                )
                Text("Cfop Industrializacao")
            }
        }
        LaunchedEffect(uiState.categorySelected) {
            homeViewModel.selectDataBase()
        }
        DropBoxList(homeViewModel = homeViewModel, uiState = uiState)
    }
}


@Preview(showSystemUi = true)
@Composable
private fun HomePreview() {
    CfopConvertMobileTheme {}
}