package com.example.agrawalclasses

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signUp : AppCompatActivity() {

    lateinit var Users : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val existingUser = findViewById<TextView>(R.id.existingUser)
        existingUser.setOnClickListener {
            intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        val etname = findViewById<TextInputEditText>(R.id.name)
        val etuniqueId = findViewById<TextInputEditText>(R.id.userName)
        val etemail = findViewById<TextInputEditText>(R.id.email)
        val etpassword = findViewById<TextInputEditText>(R.id.password)
        val btnSignUp = findViewById<Button>(R.id.button)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        checkBox.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setMessage("Do you agree with our terms and conditions?")
            val alert = builder1.create()
            if((checkBox.isChecked)){
                builder1.setPositiveButton("Agree", DialogInterface.OnClickListener { dialogInterface, i ->
                   checkBox.isChecked = true

                    }
                )
                builder1.setNegativeButton("Dismiss", DialogInterface.OnClickListener { dialogInterface, i ->
                    checkBox.isChecked = false
                })
                builder1.show()
            }
        }
        btnSignUp.setOnClickListener {
            val name = etname.text.toString()
            val uniqueId = etuniqueId.text.toString()
            val email = etemail.text.toString()
            val password = etpassword.text.toString()



            if(!(checkBox.isChecked)){
                Toast.makeText(this, "Please check the box.", Toast.LENGTH_SHORT).show()
            }

            if(name.isEmpty() || uniqueId.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "All Fields are Required", Toast.LENGTH_SHORT).show()
            }
            else{

                Users = FirebaseDatabase.getInstance().getReference("users")
                Users.child(uniqueId).get().addOnSuccessListener {
                    if(it.exists()){
                        Toast.makeText(this, "User Name Already Registered", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        val user = data(name, uniqueId, email, password)


                        Users = FirebaseDatabase.getInstance().getReference("users")
                        Users.child(uniqueId).setValue(user).addOnSuccessListener {
                            etname.text?.clear()
                            etuniqueId.text?.clear()
                            etemail.text?.clear()
                            etpassword.text?.clear()



                        }.addOnFailureListener {
                            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show()

                        }
                        intent = Intent(this, Intro::class.java)
                        startActivity(intent)
                        finish()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}