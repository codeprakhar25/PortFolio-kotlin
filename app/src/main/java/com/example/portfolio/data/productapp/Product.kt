package com.example.portfolio.data.productapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.portfolio.R
import com.example.portfolio.data.Products


@Composable
fun Product() {
    var products = remember {
        getProducts()
    }
    
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp), content ={
        items(products){
            ProductCard(it)
        }
    } )
}


fun getProducts() : List<Products>{
    return listOf(
        Products(
            id = "1",
            colour = Color.Magenta,
            size = 9,
            price = 1200f,
            discountPrice = 900f,
            name = "Nike Air Shoes",
            rating = 4.5f,
            image = R.drawable.ic_chat
        ),
        Products(
            id = "2",
            colour = Color.Magenta,
            size = 9,
            price = 1200f,
            discountPrice = 900f,
            name = "Nike Air Shoes",
            rating = 4.5f,
            image = R.drawable.ic_chat
        ),
        Products(
            id = "3",
            colour = Color.Magenta,
            size = 9,
            price = 1200f,
            discountPrice = 900f,
            name = "Nike Air Shoes",
            rating = 4.5f,
            image = R.drawable.ic_chat
        ),
        Products(
            id = "4",
            colour = Color.Magenta,
            size = 9,
            price = 1200f,
            discountPrice = 900f,
            name = "Nike Air Shoes",
            rating = 4.5f,
            image = R.drawable.ic_chat
        ),
        Products(
            id = "5",
            colour = Color.Magenta,
            size = 9,
            price = 1200f,
            discountPrice = 900f,
            name = "Nike Air Shoes",
            rating = 4.5f,
            image = R.drawable.ic_chat
        ),
        Products(
            id = "6",
            colour = Color.Magenta,
            size = 9,
            price = 1200f,
            discountPrice = 900f,
            name = "Nike Air Shoes",
            rating = 4.5f,
            image = R.drawable.ic_chat
        ),
        Products(
            id = "7",
            colour = Color.Magenta,
            size = 9,
            price = 1200f,
            discountPrice = 900f,
            name = "Nike Air Shoes",
            rating = 4.5f,
            image = R.drawable.ic_chat
        ),
        Products(
            id = "8",
            colour = Color.Magenta,
            size = 9,
            price = 1200f,
            discountPrice = 900f,
            name = "Nike Air Shoes",
            rating = 4.5f,
            image = R.drawable.ic_chat
        ),
        Products(
            id = "9",
            colour = Color.Magenta,
            size = 9,
            price = 1200f,
            discountPrice = 900f,
            name = "Nike Air Shoes",
            rating = 4.5f,
            image = R.drawable.ic_chat
        ),
        Products(
            id = "10",
            colour = Color.Magenta,
            size = 9,
            price = 1200f,
            discountPrice = 900f,
            name = "Nike Air Shoes",
            rating = 4.5f,
            image = R.drawable.ic_chat
        ),

    )
}