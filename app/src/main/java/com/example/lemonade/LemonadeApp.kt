package com.example.lemonade

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun LemonadeApp(
    viewModel: LemonadeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Lemonade",
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            fontSize = TextUnit(30F, TextUnitType.Sp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(150.dp))
        Image(
            painter = painterResource(id = uiState.imageResource),
            contentDescription = null,
            Modifier.clickable {
                viewModel.ChangeTheState()
            })
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = uiState.text,
            fontSize = TextUnit(20f, TextUnitType.Sp),
            fontWeight = FontWeight.SemiBold
        )
    }
}