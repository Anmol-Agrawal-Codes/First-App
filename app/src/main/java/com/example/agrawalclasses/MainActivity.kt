package com.example.agrawalclasses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var Users : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etname = findViewById<TextInputEditText>(R.id.name)
        val etuniqueId = findViewById<TextInputEditText>(R.id.userName)
        val etemail = findViewById<TextInputEditText>(R.id.email)
        val etpassword = findViewById<TextInputEditText>(R.id.password)
        val btnSignUp = findViewById<Button>(R.id.button)
        btnSignUp.setOnClickListener {
            val name = etname.text.toString()
            val uniqueId = etuniqueId.text.toString()
            val email = etemail.text.toString()
            val password = etpassword.text.toString()

            val user = data(name, uniqueId, email, password)


            Users = FirebaseDatabase.getInstance().getReference("users")
            Users.child(uniqueId).setValue(user).addOnSuccessListener {
                etname.text?.clear()
                etuniqueId.text?.clear()
                etemail.text?.clear()
                etpassword.text?.clear()


                Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                etname.text?.clear()
                etuniqueId.text?.clear()
                etemail.text?.clear()
                etpassword.text?.clear()
                Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show()
                val myIntent = intent
                finish()
                startActivity(myIntent)
            }
            intent = Intent(this, Intro::class.java)
            startActivity(intent)
        }
    }
}
