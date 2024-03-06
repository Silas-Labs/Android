package com.example.pastryworld.weather.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LocationsViewModel:ViewModel() {
    var _testDate  = mutableStateOf(
        mutableListOf(
                Location(country = "Kenya", name = "Kapsabet", region = "Rift"),
                Location(country = "Algeria", name = "Algiers", region = "Alger"),
                Location(country = "Romania", name = "Bucharest" , region = "Bucharest"),
                Location(country = "Switzerland", name = "Zagreb" , region = "Switz"),
                Location(country = "Canada", name = "Ottawa", region = "Ontario")
            )
    )

    val testDate : State<List<Location>> = _testDate

    fun updateData(updateLocation: List<Location>){
        _testDate.value = updateLocation.toMutableList()
    }

    }