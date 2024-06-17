package com.example.portfolio.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.example.portfolio.DestinationScreen


@Composable
fun SignupScreen( navController: NavController) {
    Box(modifier = Modifier
        .fillMaxHeight()
    ){
        Column(modifier = Modifier
            .fillMaxHeight()
            .wrapContentHeight()
            .verticalScroll(rememberScrollState())
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var nameState = remember {
                mutableStateOf(TextFieldValue)
            }

//            Image(painter = painterResource(id = R.drawable.social), contentDescription = null)
//            OutlinedTextField(value = nameState.value, onValueChange = {
//                nameState=.value = it
//            })
//            TextField(value = "test", onValueChange = {})
//            TextField(value = "test", onValueChange = {})
//            TextField(value = "test", onValueChange = {})
            Button(onClick = { navController.navigate(DestinationScreen.Login.route) }) {
                Text(text ="Submit")
            }
        }
    }
     Text(text = "Navigate to this Screen" , modifier = Modifier.clickable { navController.navigate(DestinationScreen.Login.route) })
}