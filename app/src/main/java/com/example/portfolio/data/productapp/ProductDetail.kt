package com.example.portfolio.data.productapp

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun ProductDetail(productId: String = "1") {

    var product = getProducts().find {
        it.id === productId
    }!!

    var selectedColor by remember {
        mutableStateOf(product.colour)
    }

    var xoffset by remember {
        mutableStateOf(800.dp)
    }

    var productScale by remember {
        mutableFloatStateOf(.6f)
    }

    var productRotate by remember {
        mutableFloatStateOf(-60f)
    }

    val animationXOffset = animateDpAsState(
        targetValue = xoffset,
        label = "",
        animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing)
    )

    var yoffset by remember {
        mutableStateOf(800.dp)
    }
    val animationYOffset = animateDpAsState(
        targetValue = yoffset,
        label = "",
        animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing)
    )

    val animateProductScale = animateFloatAsState(targetValue = productScale)
    val animateProductRotation = animateFloatAsState(targetValue = productRotate)

    LaunchedEffect(true) {
        delay(150)
        xoffset = 140.dp
        yoffset = (-130).dp
        productScale = 1f
        productRotate = -30f
    }

    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .offset(x = animationXOffset.value, y = animationYOffset.value)
                .background(color = selectedColor, shape = CircleShape)
                .alpha(.3f)
                .size(400.dp)
        )

        IconButton(
            onClick = { },
            modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(22.dp))
                .shadow(
                    elevation = 24.dp,
                    spotColor = DefaultShadowColor,
                    shape = RoundedCornerShape(22.dp)
                )
                .padding(start = 16.dp, top = 14.dp)
                .size(36.dp)
        ) {
            Icon(imageVector = Icons.Rounded.KeyboardArrowLeft, contentDescription = "back")
        }

        Column {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = "img",
                modifier = Modifier
                    .padding(top = 18.dp)
                    .scale(animateProductScale.value)
                    .rotate(animateProductRotation.value)
                    .size(330.dp)
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),Arrangement.SpaceBetween) {
                Column {
                    Text(text = "Sneakers", color = Color.Black, fontSize = 12.sp)
                    Text(text = "Shoes", color = Color.Black, fontSize = 20.sp)
                    Row {
                        Icon(imageVector = Icons.Default.Star, tint = Color.Yellow, contentDescription = "icon")
                        Text(text = "Sneakers", color = Color.Black, fontSize = 12.sp)
                    }
                }
                Text(text = "Rs. ${product.discountPrice}",color = Color.Black, fontSize = 30.sp, textAlign = TextAlign.Center )
            }

        }

    }
}