package com.skill.labs.weatherapp.composables.interfaces

import com.skill.labs.weatherapp.models.CurrentWeather
import com.skill.labs.weatherapp.models.Location


import retrofit2.http.GET
import retrofit2.http.Query

interface weatherApi {

    @GET("search.json?")
    suspend fun getLocation(

        @Query("key") key:String,
        @Query("q") q: String):List<Location>

    @GET("current.json?")
    suspend fun getCurrentWeather(
        @Query("key") key:String,
        @Query("q") q: String): CurrentWeather

}