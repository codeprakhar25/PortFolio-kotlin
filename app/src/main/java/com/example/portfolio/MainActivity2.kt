package com.example.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portfolio.screens.*
import com.example.portfolio.ui.theme.PortfolioTheme
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

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

@AndroidEntryPoint
class MainActivity2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var auth: FirebaseAuth = Firebase.auth

        var signInRequest = BeginSignInRequest.builder()
           .setGoogleIdTokenRequestOptions(
               BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                   .setSupported(true)
                   .setServerClientId(getString(R.string.default_web_client_id))
                   .setFilterByAuthorizedAccounts(true)
                   .build()
           )
           .build();

        val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        var currentUser = auth.getCurrentUser()
        if(currentUser!=null){
            setContent {
            PortfolioTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation("signup")
                }}}
        }else{
            setContent {
                PortfolioTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NvTest()
                    }}}
        }
//        setContent {
//            PortfolioTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
////                    NvTest()
//                    Navigation()
////                    WeatherScreen(viewModel = weatherViewModel)
//                }
//            }
//        }
    }
}

@Composable
fun Navigation(startDestination: String) {
    val navcontrol = rememberNavController()

    NavHost(navController = navcontrol, startDestination = startDestination) {
        composable(DestinationScreen.Signup.route) {
            SignUpScreen(navcontrol)
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