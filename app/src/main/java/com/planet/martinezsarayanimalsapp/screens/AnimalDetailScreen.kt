package com.planet.martinezsarayanimalsapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.google.gson.annotations.SerializedName
import com.planet.martinezsarayanimalsapp.models.EnvironmentsItem
import com.planet.martinezsarayanimalsapp.models.NatureItem
import com.planet.martinezsarayanimalsapp.services.EnvironmentsService
import com.planet.martinezsarayanimalsapp.services.NatureService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun AnimalDetailScreen(
    innerPadding : PaddingValues,
    animalId: String
    ){

    val scope = rememberCoroutineScope()
    val BASE_URL = "https://animals.juanfrausto.com/api/"
    var animal by remember {
        mutableStateOf(
            NatureItem(
                description = "",
                environmentId = "",
                facts = emptyList(),
                id = "",
                image = "",
                imageGallery = emptyList(),
                name = ""
            )
        )
    }

    LaunchedEffect(key1 = true) {
        scope.launch {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val natureService = retrofit.create(NatureService::class.java)
                val response = natureService.getAnimalById(animalId)
                animal = response
                Log.i("natureDetail",response.toString())
            } catch (e: Exception) {
                Log.e("HomeScreen", "Failed to fetch: ${e.message}", e)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = animal.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = animal.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = animal.description,
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}