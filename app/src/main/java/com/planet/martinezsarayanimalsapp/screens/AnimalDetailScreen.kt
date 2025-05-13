package com.planet.martinezsarayanimalsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AnimalDetailScreen(
    innerPadding : PaddingValues,
    animalId: String
    ){
    Column (
        modifier = Modifier
    ){
        Text(

            "animal detail with id: $animalId",
            fontSize = 36.sp,
            color = Color.Red
        )
    }
}