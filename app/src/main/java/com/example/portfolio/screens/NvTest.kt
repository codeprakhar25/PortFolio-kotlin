package com.example.portfolio.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.portfolio.WeatherViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NvTest() {

    val navItemList = listOf(
        ItemNav("Home", Icons.Default.Home),
        ItemNav("Notification", Icons.Default.Notifications),
        ItemNav("Settings", Icons.Default.Settings)
    )

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navitem ->
                    NavigationBarItem(selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = { Icon(imageVector = navitem.icon, contentDescription = "Icon") },
                        label = { Text(text = navitem.label) }
                    )

                }

            }
        }
    ) { innerPadding ->
        Main(modifier = Modifier.padding(innerPadding), selectedIndex = selectedIndex)
    }
}

@Composable
fun Main(modifier: Modifier = Modifier,selectedIndex:Int) {
when(selectedIndex){
    0-> Login()
    1-> WeatherScreen(viewModel = WeatherViewModel())
    2-> Profile()
}
}