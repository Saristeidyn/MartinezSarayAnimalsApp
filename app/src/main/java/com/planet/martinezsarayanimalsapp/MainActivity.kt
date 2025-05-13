package com.planet.martinezsarayanimalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.planet.martinezsarayanimalsapp.screens.AnimalDetailScreen
import com.planet.martinezsarayanimalsapp.screens.EnviormentDetailScreen
import com.planet.martinezsarayanimalsapp.screens.EnviormentScreen
import com.planet.martinezsarayanimalsapp.screens.HomeScreen
import com.planet.martinezsarayanimalsapp.ui.theme.MartinezSarayAnimalsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MartinezSarayAnimalsAppTheme {
                var selectedScreen by remember {
                    mutableStateOf("inicio")
                }
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                        .background(Color.Gray),
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent,
                    bottomBar = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .width(250.dp)
                                    .clip(RoundedCornerShape(50.dp))
                                    .align(Alignment.BottomCenter)
                            ) {
                                NavigationBar(
                                    containerColor = Color(0xFFFFF8DC).copy(alpha = 0.8f),
                                    modifier = Modifier.clip(RoundedCornerShape(30.dp)),

                                ) {
                                    NavigationBarItem(
                                        selected = selectedScreen == "inicio",
                                        onClick = {
                                            selectedScreen = "inicio"
                                            navController.navigate("inicio")
                                        },
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Default.Home,
                                                contentDescription = "Inicio",
                                                modifier = Modifier.size(30.dp)
                                            )
                                        },
                                        label = { Text("Inicio") },
                                        alwaysShowLabel = true
                                    )
                                    NavigationBarItem(
                                        selected = selectedScreen == "ambiente",
                                        onClick = {
                                            selectedScreen = "ambiente"
                                            navController.navigate("ambiente")
                                                  },
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Default.Place,
                                                contentDescription = "Ambiente",
                                                modifier = Modifier.size(30.dp)
                                            )
                                        },
                                        label = { Text("Ambiente") },
                                        alwaysShowLabel = true
                                    )
                                }
                            }
                        }
                    }
                )
                { innerPadding ->
                    NavHost(navController = navController, startDestination = "inicio"){
                        composable(route = "inicio") {
                            HomeScreen(innerPadding = innerPadding, navController = navController)
                        }
                        composable(
                            route = "animal-detail-screen/{id}",
                            arguments = listOf(
                                navArgument("id"){
                                    type= NavType.StringType
                                    nullable=false
                                }
                            )
                        ){
                            val id = it.arguments?.getString("id") ?: ""
                            AnimalDetailScreen(
                                innerPadding = innerPadding,
                                animalId = id
                            )
                        }



                        composable(route = "ambiente") {
                            EnviormentScreen(
                                innerPadding = innerPadding,
                                navController = navController,
                                onAguilasClick = { id ->
                                    navController.navigate("enviorment-detail-screen/$id")
                                }
                            )
                        }
                        composable(
                            route = "enviorment-detail-screen/{id}",
                            arguments = listOf(
                                navArgument("id"){
                                    type= NavType.StringType
                                    nullable=false
                                }
                            )
                        ){
                            val id = it.arguments?.getString("id") ?: ""
                            EnviormentDetailScreen(
                                innerPadding = innerPadding,
                                enviormentId = id
                            )
                        }
                    }
                }
            }
        }
    }
}

