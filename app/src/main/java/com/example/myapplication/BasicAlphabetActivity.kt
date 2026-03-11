package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class BasicAlphabetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_alphabet)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.nav_alphabet

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, SecondActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_decks -> {
                    startActivity(Intent(this, CreateFlashcardActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_alphabet -> true // Already here
                else -> {
                    Toast.makeText(this, "Coming soon!", Toast.LENGTH_SHORT).show()
                    true
                }
            }
        }
    }
}