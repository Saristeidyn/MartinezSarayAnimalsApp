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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.planet.martinezsarayanimalsapp.ui.theme.MartinezSarayAnimalsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MartinezSarayAnimalsAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                        .background(Color.Gray),
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent,
                    bottomBar = {
                        Box(
                            modifier = Modifier
                                .padding(12.dp)
                                .clip(RoundedCornerShape(30.dp))
                                .background(Color(0xFFFFF8DC)) // creamy yellow
                        ) {
                            NavigationBar(
                                containerColor = Color.Transparent, // already using background in Box
                                tonalElevation = 0.dp, // to keep it flat if you want
                                modifier = Modifier.clip(RoundedCornerShape(30.dp))
                            ) {
                                NavigationBarItem(
                                    selected = true,
                                    onClick = { /* Navigate to Animals */ },
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
                                    selected = false,
                                    onClick = { /* Navigate to Ambientes */ },
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
                )
                { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MartinezSarayAnimalsAppTheme {
        Greeting("Android")
    }
}