package com.example.agrawalclasses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Intro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val name = intent.getStringExtra(SignIn.KEY)

        val greet = findViewById<TextView>(R.id.greeting)
        greet.text = "Welcome $name \n Developer Classes"
        val btnCourse = findViewById<Button>(R.id.btnExplore)
        btnCourse.setOnClickListener {
            intent = Intent(this, SecondPage::class.java)
            startActivity(intent)
        }

    }
}