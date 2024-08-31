package com.talespalma.cfopconvertmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talespalma.cfopconvertmobile.ui.home.HomeScreenState
import com.talespalma.cfopconvertmobile.ui.home.HomeViewModel


@Composable
fun DropBoxList(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    uiState: HomeScreenState
) {

    Box(modifier = Modifier.padding(top = 50.dp, end = 5.dp, start = 5.dp, bottom = 30.dp)){
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .clickable { homeViewModel.updateExpanded(true) }
                .background(color = Color(color = 0).copy(alpha = 0.5f))
                .padding(16.dp),
        ) {
            Column {
                Text(
                    text = "Selecionado:${uiState.cfopSelected}",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth()
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Drop Down",
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }

        DropdownMenu(
            modifier = Modifier.align(Alignment.Center),
            expanded = uiState.expanded,
            onDismissRequest = { homeViewModel.updateExpanded(false) }) {
            uiState.cfops.forEach { cfop ->
                DropdownMenuItem(
                    modifier = Modifier.background(Color.Black),
                    text = { Text(text = cfop.code, color = Color.White) },
                    onClick = {
                        homeViewModel.updateCfopSelected(cfop.code)
                        homeViewModel.updateCfopConvetido(cfop.covertindCode)
                        homeViewModel.updateExpanded(false)
                    },
                )
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun PreviewDropBox() {
    DropBoxList(
        homeViewModel = HomeViewModel(null),
        uiState = HomeScreenState()
    )
}
