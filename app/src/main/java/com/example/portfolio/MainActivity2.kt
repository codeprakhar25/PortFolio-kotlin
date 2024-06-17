package com.example.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portfolio.screens.Login
import com.example.portfolio.screens.SignupScreen
import com.example.portfolio.screens.WeatherScreen
import com.example.portfolio.ui.theme.PortfolioTheme

sealed class DestinationScreen(var route: String) {
    object Signup : DestinationScreen("signup")
    object Login : DestinationScreen("login")
    object Profile : DestinationScreen("profile")
    object ChatList : DestinationScreen("chat-list")
    object SingleChat : DestinationScreen("chat/{chatId}") {
        fun createRoute(id: String) = "chat/$id"
    }

    object StatusList : DestinationScreen("status-list")
    object SingleStatus : DestinationScreen("status/{chatId}") {
        fun createRoute(userId: String) = "status/$userId"
    }
}

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]








        setContent {
            PortfolioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Navigation()
                    WeatherScreen(viewModel = weatherViewModel)
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navcontrol = rememberNavController()

    NavHost(navController = navcontrol, startDestination = DestinationScreen.Signup.route) {
        composable(DestinationScreen.Signup.route) {
            SignupScreen(navcontrol)
        }
        composable(DestinationScreen.Login.route) {
            Login()
        }
        composable(DestinationScreen.Profile.route) {
            com.example.portfolio.screens.Profile()
        }
        composable(DestinationScreen.ChatList.route) {
            com.example.portfolio.screens.ChatListScreen()
        }
    }
}