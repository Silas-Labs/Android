package com.example.pastryworld.composables

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pastryworld.Login
import com.example.pastryworld.R
import com.example.pastryworld.ui.theme.colorPrimary
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(navController: NavHostController) {
    val loginMethod:Login = Login()
    var auth: FirebaseAuth
    val context = LocalContext.current
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6B0BD9)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(100.dp))

        /* Image(
             modifier = Modifier,
             alignment = Alignment.Center,
             painter = painterResource(id = R.drawable.glows),
             contentDescription = "Cupcake"
         )*/

        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(
            label = { Text("Email/Username") },
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .requiredWidth(TextFieldDefaults.MinWidth),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color(0xFFDCE6EB),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = colorPrimary,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Black
            ),
            value = username, onValueChange = { username = it })

        Spacer(modifier = Modifier.padding(10.dp))

        OutlinedTextField(
            label = { Text("Password") },
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            modifier = Modifier
                .requiredWidth(TextFieldDefaults.MinWidth),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color(0xFFDCE6EB),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = colorPrimary,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Black,
                focusedTrailingIconColor = Color.Blue,
                unfocusedTrailingIconColor = Color.Gray
            ),
            trailingIcon = { Icons.Filled.AddCircle },

            value = password, onValueChange = { password = it })

        Spacer(modifier = Modifier.padding(10.dp))

        ElevatedButton(onClick = {
            auth = FirebaseAuth.getInstance()
            auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        navController.navigate("dashboard")
                    }
                }.addOnFailureListener {
                    Toast.makeText(
                        context,
                        "Failed to authenticate.Check credentials and try again",
                        Toast.LENGTH_SHORT
                    ).show()
                }

        }) {
            Text(text = "Sign In")
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Row {
            Text(text = "Do not Have an Account? Create one ", color = Color.White)
            Text(text = "HERE", color = Color.White,
                modifier = Modifier.clickable {
                    navController.navigate("signup")
                })
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Or login with",
            color = Color.White
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            horizontalArrangement = Arrangement.Center
        )
        {
            /*Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "google",
                tint = Color.Cyan,
                modifier = Modifier
                    .clickable {

                        Toast
                            .makeText(context, "Google", Toast.LENGTH_SHORT)
                            .show()
                        loginMethod.signInWithGoogle(context)
                    }
                    .size(30.dp)
            )*/
            Spacer(modifier = Modifier.padding(10.dp))
            /*Icon(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "facebook",
                tint = Color.Cyan,
                modifier = Modifier
                    .clickable {
                        Toast
                            .makeText(context, "Facebook", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .size(30.dp)
            )*/
        }
    }
}

