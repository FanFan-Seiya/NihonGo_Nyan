package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class CreateFlashcardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_flashcard)

        val deckNameInput = findViewById<EditText>(R.id.deckNameInput)
        val flashcardListContainer = findViewById<LinearLayout>(R.id.flashcardListContainer)
        val btnAddCard = findViewById<Button>(R.id.btnAddCard)
        val btnCreateFinal = findViewById<Button>(R.id.btnCreateFinal)
        val btnCreatePractice = findViewById<Button>(R.id.btnCreatePractice)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        
        // Set 'Decks' as selected
        bottomNavigation.selectedItemId = R.id.nav_decks

        // Function to add a new card item to the container
        fun addNewCardItem() {
            val inflater = LayoutInflater.from(this)
            val newCardView = inflater.inflate(R.layout.item_flashcard_input, flashcardListContainer, false)
            flashcardListContainer.addView(newCardView)
        }

        // Add logic for 'Add' button to create a new card field
        btnAddCard.setOnClickListener {
            addNewCardItem()
            Toast.makeText(this, "New flashcard added to list", Toast.LENGTH_SHORT).show()
        }

        // Logic for Create buttons
        btnCreateFinal.setOnClickListener {
            val deckName = deckNameInput.text.toString().trim()
            if (deckName.isNotEmpty()) {
                Toast.makeText(this, "Deck '$deckName' created with ${flashcardListContainer.childCount} cards!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter a deck name", Toast.LENGTH_SHORT).show()
            }
        }

        btnCreatePractice.setOnClickListener {
            Toast.makeText(this, "Starting practice session...", Toast.LENGTH_SHORT).show()
        }

        // Handle Bottom Navigation clicks
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, SecondActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_lessons -> {
                    startActivity(Intent(this, LessonListActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_quiz -> {
                    startActivity(Intent(this, QuizModeActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_alphabet -> {
                    startActivity(Intent(this, BasicAlphabetActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_decks -> true // Already here
                else -> false
            }
        }
    }
}