package com.example.portfolio

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portfolio.api.Response
import com.example.portfolio.api.RetrofitInstance
import com.example.portfolio.data.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {


    private val weatherApi = RetrofitInstance.weatherapi
    private val result = MutableLiveData<Response<WeatherModel>>()
    val weatherresult: LiveData<Response<WeatherModel>> = result

    fun getData(city: String) {
        Log.i("City Name is", city)
        result.value = Response.Loading
        viewModelScope.launch {
            try {
                val response = weatherApi.getWeather("3fa86ef2e1514d7fbcd62844241706", city)
                if (response.isSuccessful) {
                    Log.i("response is", response.body().toString())
                    response.body()?.let {
                        result.value = Response.Success(it)
                    }
                } else {
                    Log.i("error", response.message())
                    result.value = Response.Error("Failed to load Data")
                }
            } catch (e: Exception) {
                result.value = Response.Error("Failed to load Data")
            }

        }

    }
}