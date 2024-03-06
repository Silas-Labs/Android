package com.example.pastryworld.composables

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pastryworld.ui.theme.colorPrimary
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignUpScreen(navController: NavHostController) {
    val context = LocalContext.current
    lateinit var auth: FirebaseAuth
    var fullName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var confirmPass by remember {
        mutableStateOf("")
    }

    var fullNameBlank by remember {
        mutableStateOf(false)
    }
    var passwordBlank by remember {
        mutableStateOf(false)
    }
    var emailBlank by remember {
        mutableStateOf(false)
    }
    var confirmPassBlank by remember {
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFD96B0B))
            .padding(16.dp)
            .fillMaxSize()
    )
    {
        OutlinedTextField(
            value = fullName,
            shape = RoundedCornerShape(20.dp),
            onValueChange = { fullName = it },
            label = { Text(text = "First Name") },
            isError = fullNameBlank,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color(0xFFDCE6EB),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = colorPrimary,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            ),
            textStyle = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .padding(16.dp)

        )

        OutlinedTextField(
            value = email,
            shape = RoundedCornerShape(20.dp),
            onValueChange = { email = it },
            isError = emailBlank,
            label = { Text(text = "Email") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color(0xFFDCE6EB),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = colorPrimary,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            ),
            textStyle = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .padding(16.dp)
        )

        OutlinedTextField(
            value = password,
            shape = RoundedCornerShape(20.dp),
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            isError = passwordBlank,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color(0xFFDCE6EB),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = colorPrimary,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            ),
            textStyle = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .padding(16.dp)
        )
        OutlinedTextField(
            value = confirmPass,
            shape = RoundedCornerShape(20.dp),
            onValueChange = { confirmPass = it },
            isError = confirmPassBlank,
            label = { Text(text = "Confirm Password") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color(0xFFDCE6EB),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = colorPrimary,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Black

            ),
            textStyle = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .padding(16.dp)
        )
        ElevatedButton(onClick = {
            auth= FirebaseAuth.getInstance()
                    auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener {
                            if(it.isComplete){
                                if(it.isSuccessful){
                                    Toast.makeText(context, "Success. Check your email", Toast.LENGTH_SHORT).show()
                                }else{
                                    Toast.makeText(context, "Error Signing up-${it.exception}", Toast.LENGTH_SHORT).show()
                                }
                            }else{
                                Toast.makeText(context, "Check your connection", Toast.LENGTH_SHORT).show()
                            }
                        }
        }) {
            Text(text = "Sign Up")
        }
        Spacer(modifier = Modifier.padding(10.dp))

        Row {
            Text(text = "Have an account?")
            Text(text = "Log in",
                modifier = Modifier.clickable {
                    navController.navigate("login")
                })
        }

    }


}