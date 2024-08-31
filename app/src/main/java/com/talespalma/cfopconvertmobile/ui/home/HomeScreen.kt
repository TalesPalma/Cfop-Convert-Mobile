package com.talespalma.cfopconvertmobile.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.talespalma.cfopconvertmobile.ui.components.DropBoxList
import com.talespalma.cfopconvertmobile.ui.components.RadioButtons
import com.talespalma.cfopconvertmobile.ui.theme.CfopConvertMobileTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Home(
    modifier: Modifier = Modifier,
) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val uiState by homeViewModel.uiState.collectAsState()
    Column(
        modifier = modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .wrapContentWidth(align = Alignment.CenterHorizontally),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

                DropBoxList(homeViewModel = homeViewModel, uiState = uiState)
                RadioButtons(homeViewModel = homeViewModel, uiState = uiState, modifier = Modifier)
        LaunchedEffect(uiState.categorySelected) {
            homeViewModel.selectDataBase()
        }

        Spacer(modifier = Modifier.height(100.dp))
        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0).copy(0.5F))
                .padding(30.dp),
            text = "Convertido -> ${uiState.cfopConvetido}",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}


@Preview(showSystemUi = true)
@Composable
private fun HomePreview() {
        Home()
}