package com.talespalma.cfopconvertmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talespalma.cfopconvertmobile.ui.home.HomeScreenState
import com.talespalma.cfopconvertmobile.ui.home.HomeViewModel


@Composable
fun RadioButtons(
    modifier: Modifier = Modifier,
    uiState: HomeScreenState,
    homeViewModel: HomeViewModel
) {
    val radioColors = RadioButtonColors(
        selectedColor = Color.Black,
        unselectedColor = Color.LightGray,
        disabledSelectedColor = Color.White,
        disabledUnselectedColor = Color.White
    )

    Column(
        modifier = modifier.clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color(0xFF, 0xFF, 0xFF).copy(alpha = 1.0F))
            .padding(top = 30.dp, end = 30.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        Row{
            androidx.compose.material3.RadioButton(
                onClick = { homeViewModel.updateCategory(1) },
                selected = (uiState.categorySelected == 1),
                colors = radioColors
            )
            Text("CFOP CONSUMO", color = Color.Black,fontWeight = FontWeight.Bold)
        }
        Row {
            androidx.compose.material3.RadioButton(
                onClick = { homeViewModel.updateCategory(2) },
                selected = (uiState.categorySelected == 2),
                colors = radioColors
            )
            Text("CFOP REVENDA", color = Color.Black,fontWeight = FontWeight.Bold)
        }
        Row {
            androidx.compose.material3.RadioButton(
                onClick = { homeViewModel.updateCategory(3) },
                selected = (uiState.categorySelected == 3),
                colors = radioColors
            )
            Text("CFOP INDUSTRIALIZAÇÃO", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewRadioButton() {
    RadioButtons(
        homeViewModel = HomeViewModel(null),
        uiState = HomeScreenState()
    )
}