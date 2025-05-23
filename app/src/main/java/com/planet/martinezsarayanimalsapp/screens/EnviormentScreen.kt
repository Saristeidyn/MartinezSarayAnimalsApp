package com.planet.martinezsarayanimalsapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.planet.martinezsarayanimalsapp.R
import com.planet.martinezsarayanimalsapp.models.EnvironmentsItem
import com.planet.martinezsarayanimalsapp.services.EnvironmentsService
import com.planet.martinezsarayanimalsapp.services.NatureService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun EnviormentScreen (
    innerPadding: PaddingValues,
    navController: NavHostController,
    onAguilasClick: (String) -> Unit
){
    var environmentsList by remember {
        mutableStateOf<List<EnvironmentsItem>>(emptyList())
    }
    val scope = rememberCoroutineScope()
    val BASE_URL = "https://animals.juanfrausto.com/api/"

    LaunchedEffect(key1 = true) {
        scope.launch {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val environmentsService = retrofit.create(EnvironmentsService::class.java)
                environmentsList = environmentsService.getEnvironments()
            } catch (e: Exception) {
                Log.e("HomeScreen", "Failed to fetch: ${e.message}", e)
            }
        }
    }

    // ✅ Check if list is empty, not null
    if (environmentsList.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Loading or failed to fetch data...",
                color = Color.White,
                fontSize = 16.sp
            )
        }
        return // Avoid drawing the rest of the UI
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Ambientes",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

            }
        }

        items(environmentsList) { environment ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF444444))
                    .padding(16.dp)
                    .clickable {
                        Log.i("ClickedEnvironment", environment._id.toString())
                        navController.navigate("enviorment-detail-screen/${environment._id}")
                    },

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(8.dp))



                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                ) {
                    AsyncImage(
                        model = environment.image,
                        contentDescription = "Environment Image",
                        placeholder = painterResource(R.drawable.ic_launcher_background),
                        error = painterResource(R.drawable.ic_launcher_background),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.matchParentSize()
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = environment.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}