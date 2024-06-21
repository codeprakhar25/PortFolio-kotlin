package com.example.portfolio.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Products(
    val id: String,
    val name: String,
    val rating: Float,
    val colour:Color,
    val price:Float,
    val discountPrice:Float,
    val size:Int,
    @DrawableRes val image :Int

)
