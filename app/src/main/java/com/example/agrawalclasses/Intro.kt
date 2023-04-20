package com.example.agrawalclasses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.agrawalclasses.databinding.ActivityIntroBinding


class Intro : AppCompatActivity() {
    lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(SignIn.KEY)

        binding.greeting.text = "Welcome $name \n Developer Classes"
        val btnCourse = findViewById<Button>(R.id.btnExplore)
        btnCourse.setOnClickListener {
            intent = Intent(this, SecondPage::class.java)
            startActivity(intent)
        }

    }
}