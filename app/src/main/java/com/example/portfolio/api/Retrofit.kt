package com.example.portfolio.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

   private const val baseUrl = "https://api.weatherapi.com";

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val weatherapi : WeatherAp = getInstance().create(WeatherAp::class.java)
}