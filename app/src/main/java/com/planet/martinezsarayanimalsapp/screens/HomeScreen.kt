package com.planet.martinezsarayanimalsapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen (innerPadding: PaddingValues){
    Column (
        modifier = Modifier.padding(innerPadding)
    ){
        Text(text = "text")
    }
}