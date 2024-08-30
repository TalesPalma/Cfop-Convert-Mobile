package com.talespalma.cfopconvertmobile.ui.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun ContactScreen(
    modifier: Modifier = Modifier,
    name: String?
) {
    Column(modifier = modifier) {
        Text(text = "Ola $name", modifier = Modifier.padding(100.dp))
    }
}