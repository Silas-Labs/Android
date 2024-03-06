package com.skill.labs.weatherapp.composables

import android.content.Context
import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.skill.labs.weatherapp.R
import com.skill.labs.weatherapp.models.CurrentWeather
import com.skill.labs.weatherapp.models.Location

@Composable
fun Weather() {
    var context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("locations", Context.MODE_PRIVATE)
    val gsonConverter = Gson()
    val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    var savedLocationsSharedPreferences by remember{
        mutableStateOf(
            getStringToList(
                sharedPreferences.getString(
                    "locations",
                    null
                ), gsonConverter
            )
        )
    }
    var selectedDay by remember {
        mutableIntStateOf(-1)
    }
    var locationWeather by remember{
        mutableStateOf( listOf<CurrentWeather>())
    }
    var currentLocationWeather by remember {
        mutableStateOf(locationWeather)
    }

    locationWeather = savedLocationsSharedPreferences

    LaunchedEffect(key1 = getStringToList(sharedPreferences.getString("locations",null),gsonConverter).toList()) {
        currentLocationWeather = getStringToList(sharedPreferences.getString("locations",null),gsonConverter).toList()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(0.3f)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(128.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Current Weather"
                )
                Text(
                    text = "Nairobi City",
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Text(
                    text = "28°",
                    fontWeight = FontWeight.Bold,
                    fontSize = 48.sp,
                    color = Color.White
                )
            }
        }

        LazyRow(//Days of the week
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(vertical = 16.dp)
        ) {
            itemsIndexed(daysOfWeek) { it, s ->
                Text(
                    textAlign = TextAlign.Center,
                    text = s,
                    color = Color.White,
                    modifier = Modifier
                        .clickable {
                            selectedDay = it
                        }
                        .width(width = 30.dp)
                        .background(
                            shape = RoundedCornerShape(10.dp),
                            color = if (selectedDay == it) Color.DarkGray else Color.Transparent
                        )
                )
            }
        }
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .clickable { },
            text = "Locations",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.White
        )
        if(currentLocationWeather.isNotEmpty()) {
            LazyColumn(//Added Locations
                modifier = Modifier.fillMaxHeight(0.785f)
            ) {

                itemsIndexed(currentLocationWeather) { _, location ->

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.DarkGray)
                    )
                    {
                        Column(
                            modifier = Modifier.padding(
                                start = 16.dp,
                                bottom = 10.dp,
                                top = 10.dp
                            ),
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Text(
                                text = "${location.current.temp_c}°",
                                color = Color.White,
                                fontWeight = FontWeight.Normal,
                                fontSize = 24.sp
                            )
                            Text(
                                text = location.location.name,
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        }
                        Image(
                            alignment = Alignment.Center,
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "Current weather",
                            modifier = Modifier.padding(end = 10.dp)
                        )
                    }
                }
            }
        }else{
            Text(text = "No Locations Added")
        }
    }
}

fun getLocationsToList(locationString: String,gsonConverter: Gson): List<Location>? {
    return if(locationString != null) {
        val locationsList = object : TypeToken<List<Location>>() {}.type
        gsonConverter.fromJson<List<Location>>(locationString, locationsList)
    }else{
        null
    }
}




