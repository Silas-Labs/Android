package com.skill.labs.weatherapp.composables

import android.content.SharedPreferences
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.skill.labs.weatherapp.composables.interfaces.RetrofitAPI
import com.skill.labs.weatherapp.composables.interfaces.RetrofitAPI.Constants.API_KEY
import com.skill.labs.weatherapp.models.CurrentWeather
import com.skill.labs.weatherapp.ui.theme.colorSurface

@Composable
fun Locations() {
    val context = LocalContext.current
    val gsonConverter = Gson()
    val sharedPreferences = context.getSharedPreferences("locations",
        ComponentActivity.MODE_PRIVATE
    )
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
    var responseText by remember {
        mutableStateOf("")
    }

    var locationTextField by remember {
        mutableStateOf("")
    }
    var addSearchLocation by remember {
        mutableStateOf("")
    }

    var startSearchOnClick by remember {
        mutableStateOf(false)
    }

    var addedLocationsList = rememberSaveable {
        mutableStateOf( listOf<CurrentWeather>()) }

    var addedLocations by rememberSaveable {
        mutableStateOf(addedLocationsList)
    }
    addedLocationsList.value = savedLocationsSharedPreferences.toMutableList()

    LaunchedEffect(key1 = addSearchLocation ){
        if(addSearchLocation.isNotEmpty()) {
            val response = RetrofitAPI.apiService.getCurrentWeather(q = addSearchLocation, key = API_KEY)
            val newLocation = CurrentWeather(response.location,response.current)
            val newList=addedLocationsList.value.toMutableList()
            newList.add(newLocation)
            saveToSharedPreference(sharedPreferences, convertListToJson(gsonConverter,newList))

            locationTextField=""
            addedLocations.value = addedLocationsList.value
        }
    }
    LaunchedEffect(key1 = getStringToList(
        sharedPreferences.getString(
            "locations",
            null
        ), gsonConverter
    )){
        if(!savedLocationsSharedPreferences.isNullOrEmpty()){
            addedLocationsList.value = getStringToList(
                sharedPreferences.getString(
                    "locations",
                    null
                ), gsonConverter
            ).toMutableList()

        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorSurface)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        TextField(
            modifier = Modifier.padding(top = 30.dp),
            shape = RoundedCornerShape(40.dp),
            textStyle = TextStyle(
                fontSize = 20.sp,
            ),
            placeholder = {
                Text(
                    text = "Add Location ...",
                    fontSize = 18.sp
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.LightGray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                Icon(Icons.Rounded.Search, "Search Location",
                    modifier = Modifier
                        .background(Color.LightGray, RoundedCornerShape(25.dp))
                        .clickable {
                            addSearchLocation = locationTextField
                            startSearchOnClick = !startSearchOnClick
                        })
            },
            singleLine = true,

            value = locationTextField,
            onValueChange = {
                locationTextField = it
            })
        Spacer(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp))
        )
        Text(
            modifier = Modifier,
            color = Color.White,
            text = "Added Locations"
        )

        LazyColumn(
            userScrollEnabled = true,
            modifier = Modifier.fillMaxHeight(0.8386f)
        ) {
            itemsIndexed(addedLocationsList.value) { index, item ->
                if(addedLocationsList.value.isNotEmpty()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.DarkGray)
                    ) {
                        Column(
                            modifier = Modifier.padding(start = 16.dp, bottom = 10.dp, top = 10.dp),
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Text(
                                text = item.location.name,
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                        //Delete Location on click X
                        Button(
                            //modifier = Modifier.size(ButtonDefaults.MinHeight),
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                            onClick = {
                                val newList = addedLocationsList.value.toMutableList()
                                newList.removeAt(index)
                                val toJson = convertListToJson(gsonConverter, newList)
                                saveToSharedPreference(sharedPreferences, toJson)
                                addedLocationsList.value = newList
                            })
                        {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Remove Location",
                                modifier = Modifier
                            )
                        }
                    }
                }else{
                    Text(text = responseText,
                        color=Color.White)
                }
            }
        }
    }

}

fun getStringToList(stringList: String?, stringer: Gson): List<CurrentWeather> {
    val items = object : TypeToken<List<CurrentWeather>>() {}.type
    return  stringer.fromJson(stringList, items)
}

fun convertListToJson(jsonParser: Gson, list: MutableList<CurrentWeather>): String {
    return jsonParser.toJson(list)
}

fun saveToSharedPreference(sharedPreferences: SharedPreferences, json: String) {
    sharedPreferences
        .edit()
        .putString("locations", json)
        .apply()
}
/*

fun addLocation(testList: List<CurrentWeather>, newLocation: Location) {
    val newList = testList.toMutableList()

}*/

