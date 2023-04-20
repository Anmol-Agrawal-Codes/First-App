package com.example.agrawalclasses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts.SettingsColumns.KEY
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.agrawalclasses.databinding.ActivitySignInBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignIn : AppCompatActivity() {

    lateinit var dataCheck : DatabaseReference
    lateinit var binding: ActivitySignInBinding
    companion object {
        const val KEY = "com.example.agrawalclasses.SignIn.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.newUser.setOnClickListener{
            intent = Intent(this, signUp::class.java)
            startActivity(intent)
        }

        val username = findViewById<TextInputEditText>(R.id.userName)
        val password = findViewById<TextInputEditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener {
            val userName = username.text.toString()
            val password = password.text.toString()
            if(userName.isNotEmpty() && password.isNotEmpty()){
                readData(userName, password)
            }
            else{
                Toast.makeText(this, "Please Enter valid UserName.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(userName: String, password: String) {
        dataCheck = FirebaseDatabase.getInstance().getReference("users")
        dataCheck.child(userName).get().addOnSuccessListener {
            val name : String
            if (it.exists()){
                val passWord = it.child("password").value
                if(passWord == password){
                    name = it.child("name").value.toString()
                    intent = Intent(this, Intro::class.java)
                    intent.putExtra(KEY, name)
                    startActivity(intent)
                    finish()
                }
            }


            else {
                Toast.makeText(this, "Invalid UserId or password", Toast.LENGTH_SHORT).show()
            }

            }.addOnFailureListener {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show()
        }
    }
}