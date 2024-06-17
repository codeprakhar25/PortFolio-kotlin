package com.example.portfolio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.WeatherViewModel
import com.example.portfolio.api.Response
import com.example.portfolio.data.WeatherModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    var city by remember { mutableStateOf("") }

    val weather = viewModel.weatherresult.observeAsState()
    Box() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = city,
                    onValueChange = { city = it },
                    label = { Text("Label") })
                IconButton(onClick = { viewModel.getData(city) }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search for something"
                    )
                }
            }
            when (val result = weather.value) {
                is Response.Error -> {
                    Text(text = result.message)
                }
                Response.Loading -> {
                    CircularProgressIndicator()
                }
                is Response.Success -> {
                    WeatherComponent(data = result.data)
                }
                null -> {}
            }
        }

    }
}


@Composable
fun WeatherComponent(data: WeatherModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "location")
            Text(text = "London United Kingdom", fontSize = 30.sp, modifier = Modifier.padding(10.dp))
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "11", fontSize = 50.sp, modifier = Modifier.padding(10.dp))
            Text(text = "^ C", fontSize = 50.sp, modifier = Modifier.padding(10.dp))
        }
        Icon(
            imageVector = Icons.Default.Done,
            contentDescription = "",
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = "Partly Cloudy",
            color = Color.Cyan,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.LightGray),
            verticalArrangement = Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
                Column() {
                    Text(text = "76", fontSize = 20.sp)
                    Text(text = "Humidity", fontSize = 10.sp)

                }
                Column() {
                    Text(text = "76", fontSize = 20.sp)
                    Text(text = "Humidity", fontSize = 10.sp)

                }
            }

            Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
                Column() {
                    Text(text = "76", fontSize = 20.sp)
                    Text(text = "Humidity", fontSize = 10.sp)

                }
                Column() {
                    Text(text = "76", fontSize = 20.sp)
                    Text(text = "Humidity", fontSize = 10.sp)

                }
            }

            Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
                Column() {
                    Text(text = "76", fontSize = 20.sp)
                    Text(text = "Humidity", fontSize = 10.sp)

                }
                Column() {
                    Text(text = "76", fontSize = 20.sp)
                    Text(text = "Humidity", fontSize = 10.sp)

                }
            }
        }
    }
}