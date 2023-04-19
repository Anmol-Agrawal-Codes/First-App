package com.example.agrawalclasses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast



class StartPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        Toast.makeText(applicationContext, "Welcome to Agrawal Classes!", Toast.LENGTH_SHORT).show()
        val btnExplore = findViewById<Button>(R.id.btnExplore)

        btnExplore.setOnClickListener {
            // creating new activity
            intent = Intent(applicationContext, SecondPage::class.java)
            startActivity(intent)
        }
    }

    }
