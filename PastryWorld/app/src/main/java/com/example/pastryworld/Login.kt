package com.example.pastryworld

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class Login : ViewModel(){
    private val firebaseAuth = FirebaseAuth.getInstance()

    fun signIn(email:String, password: String){
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    //Login Success
                }else{
                    //Login failed
                }
            }
    }

    fun signUp(email: String, password: String){
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    //Signup Successful
                }else{
                    //Signup Unsuccessful
                }
            }
    }
    fun signInWithGoogle(context: Context) {
        lateinit var googleSignInClient: GoogleSignInClient
        val SIGN_IN_CODE = 123

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(com.firebase.ui.auth.R.string.default_web_client_id.toString())
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(context,gso)
       // val signInIntent =
    }
}