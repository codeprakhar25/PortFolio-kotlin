package com.example.portfolio.api

import com.example.portfolio.data.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherAp {

    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("key") apiKey:String,
        @Query("q") city:String
        ): Response<WeatherModel>
}