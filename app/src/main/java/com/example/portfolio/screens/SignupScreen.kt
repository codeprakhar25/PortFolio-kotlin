package com.example.portfolio.screens

import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun SignUpScreen(
    text: String,
    navController: NavController,
    loadingText: String = "Signing in...",
    icon: Painter,
    isLoading: Boolean = false,
    shape: Shapes = Shapes(medium = ShapeDefaults.Medium),
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.clickable(
            enabled = !isLoading,
            onClick = onClick
        ),
//        shape = shape,
        border = BorderStroke(width = 1.dp, color = borderColor),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = icon,
                contentDescription = "SignInButton",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(text = if (isLoading) loadingText else text)
            if (isLoading) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
            }
        }
    }
}


fun handleSignin(data:Intent?) {
    var auth: FirebaseAuth = Firebase.auth
    val googleCredential = GoogleSignIn.getSignedInAccountFromIntent(data)
    val idToken = googleCredential.getResult()
    when {
        idToken != null -> {
            // Got an ID token from Google. Use it to authenticate
            // with Firebase.
            val firebaseCredential = GoogleAuthProvider.getCredential(idToken.idToken, null)
            auth.signInWithCredential(firebaseCredential)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithCredential:success")
                        val user = auth.currentUser
//                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", task.exception)
//                        updateUI(null)
                    }
                }
        }
        else -> {
            // Shouldn't happen.
            Log.d(TAG, "No ID token!")
        }
    }
}
