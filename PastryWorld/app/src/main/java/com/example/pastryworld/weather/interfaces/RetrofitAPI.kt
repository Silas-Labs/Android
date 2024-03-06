package com.example.pastryworld.weather.interfaces

import com.example.pastryworld.weather.interfaces.RetrofitAPI.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitAPI {
    object Constants{
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val API_KEY= "b3e4f0c754ee4c52ab270120242702"
    }

    private val retrofitApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService:weatherApi by lazy{
        retrofitApi.create(weatherApi::class.java)
    }
}