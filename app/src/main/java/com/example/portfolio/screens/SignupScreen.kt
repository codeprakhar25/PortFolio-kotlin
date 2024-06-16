package com.example.portfolio.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.portfolio.DestinationScreen


@Composable
fun SignupScreen( navController: NavController) {
    Box(modifier = Modifier){
        Column() {
            TextField(value = "test", onValueChange = {})
            TextField(value = "test", onValueChange = {})
            TextField(value = "test", onValueChange = {})
            TextField(value = "test", onValueChange = {})
            Button(onClick = { navController.navigate(DestinationScreen.Login.route) }) {
                "Submit"
            }
        }
    }
     Text(text = "Navigate to this Screen" , modifier = Modifier.clickable { navController.navigate(DestinationScreen.Login.route) })
}