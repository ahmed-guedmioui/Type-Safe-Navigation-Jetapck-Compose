package com.ag_apps.typesafenavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author Ahmed Guedmioui
 */
@Composable
fun Screen2(
    id: Int,
    onGoToNextScreen: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Screen 2 / ID: $id",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                onGoToNextScreen()
            }
        ) {
            Text(text = "Go To Screen 3", fontSize = 18.sp)
        }
    }
}