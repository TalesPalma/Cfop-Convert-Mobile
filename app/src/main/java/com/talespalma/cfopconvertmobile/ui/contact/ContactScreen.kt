package com.talespalma.cfopconvertmobile.ui.contact

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talespalma.cfopconvertmobile.R


@Composable
fun ContactScreen(
    modifier: Modifier = Modifier,
) {
    val image = painterResource(R.drawable.fundo)
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Text(
            text = "Pagina de contato",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 40.sp
        )
    }
}


@Preview(showSystemUi = true)
@Composable
private fun PreviewContactScreen() {
    ContactScreen()
}