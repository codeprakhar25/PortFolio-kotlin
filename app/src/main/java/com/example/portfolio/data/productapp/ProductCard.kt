package com.example.portfolio.data.productapp

import android.text.style.UnderlineSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.data.Products

@Composable
fun ProductCard(product: Products) {

    var isFavourite by remember {
        mutableStateOf(false)
    }
    Box(

        modifier = Modifier
            .padding(20.dp)
            .size(168.dp, 210.dp)
            .clickable { }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(.2f)
                .background(color = product.colour, shape = RoundedCornerShape(22.dp))
        )

        IconButton(onClick = { isFavourite = !isFavourite }) {
            Icon(
                imageVector =
                if (isFavourite)
                    Icons.Default.Favorite
                else
                    Icons.Default.FavoriteBorder, contentDescription = "icon"
            )
        }

        Text(
            text = product.size.toString(),
            fontSize = 120.sp,
            fontWeight = FontWeight.Bold,
            color = product.colour.copy(alpha = .3f),
            modifier = Modifier.align(Alignment.TopCenter)
        )

        Image(
            painter = painterResource(id = product.image),
            contentDescription = "image shoe",
            modifier = Modifier
                .fillMaxSize(1f)
                .align(Alignment.Center)
                .offset(30.dp, (-20).dp)
                .rotate(-30f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
        ) {
            Text(
                text = "Rs. ${product.discountPrice.toString()}",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Rs. ${product.price.toString()}",
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(end = 8.dp, bottom = 8.dp)
                    .align(Alignment.End),
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )


        }
    }

}