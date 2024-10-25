package com.talespalma.cfopconvertmobile.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.talespalma.cfopconvertmobile.R
import com.talespalma.cfopconvertmobile.ui.components.DropBoxList
import com.talespalma.cfopconvertmobile.ui.components.RadioButtons

@Composable
fun Home(
    modifier: Modifier = Modifier,
) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val uiState by homeViewModel.uiState.collectAsState()

    val image = painterResource(R.drawable.fundo)
    val colorElement  = Color(0xFF, 0xFF, 0xFF).copy(alpha = 0.10f)


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
    }
    Text(
        text = "Conversor",
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth().padding(top = 120.dp),
        style = MaterialTheme.typography.headlineLarge,
        color = Color.White,
    )
        Column(
            modifier = modifier
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
                    .background(colorElement)
                    .border(1.dp, Color.White)
                    .padding(50.dp)
                ,
                text = "Convertido -> ${uiState.cfopConvetido}",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
        }
    }



@Preview()
@Composable
private fun HomePreview() {
    Home()
}