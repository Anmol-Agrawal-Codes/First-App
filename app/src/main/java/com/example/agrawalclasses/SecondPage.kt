package com.example.agrawalclasses

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView

class SecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        Toast.makeText(applicationContext, "Courses", Toast.LENGTH_SHORT).show()
        val btnContact = findViewById<Button>(R.id.contact)
        btnContact.setOnClickListener {
            btnSetUp(btnContact)
        }

        val android = findViewById<CardView>(R.id.Android)
        android.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://developer.android.com/docs")
            startActivity(intent)
        }

        val web = findViewById<CardView>(R.id.Web)
        web.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://developer.mozilla.org/en-US/")
            startActivity(intent)
        }

        val os = findViewById<CardView>(R.id.OS)
        os.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.geeksforgeeks.org/last-minute-notes-operating-systems/")
            startActivity(intent)
        }

        val dbms = findViewById<CardView>(R.id.DBMS)
        dbms.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.geeksforgeeks.org/dbms/")
            startActivity(intent)
        }

        val dsa = findViewById<CardView>(R.id.DSA)
        dsa.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.geeksforgeeks.org/data-structures/")
            startActivity(intent)
        }

        val ios = findViewById<CardView>(R.id.IOS)
        ios.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://developer.apple.com/documentation/")
            startActivity(intent)
        }
    }

    private fun btnSetUp(btnContact : Button){
        intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+91 1234567890")
        startActivity(intent)
    }
}