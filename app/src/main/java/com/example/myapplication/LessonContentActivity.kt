package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class LessonContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_container)

        val lessonId = intent.getStringExtra("LESSON_ID")
        val mainTitle = findViewById<TextView>(R.id.mainTitle)
        val stylizedNumber = findViewById<TextView>(R.id.stylizedNumber)

        if (savedInstanceState == null) {
            val fragment: Fragment = when (lessonId) {
                "HIRAGANA_1" -> {
                    mainTitle.text = "Hiragana Part 1"
                    stylizedNumber.text = "一"
                    HiraganaPartOneFragment()
                }
                "HIRAGANA_2" -> {
                    mainTitle.text = "Hiragana Part 2"
                    stylizedNumber.text = "二"
                    HiraganaPartTwoFragment()
                }
                "HIRAGANA_3" -> {
                    mainTitle.text = "Voiced Sounds"
                    stylizedNumber.text = "三"
                    HiraganaPartThreeFragment()
                }
                "SPECIAL_CHARS" -> {
                    mainTitle.text = "Special Characters"
                    stylizedNumber.text = "四"
                    SpecialCharactersFragment()
                }
                "KATAKANA_1" -> {
                    mainTitle.text = "Katakana Part 1"
                    stylizedNumber.text = "五"
                    KatakanaIntroFragment()
                }
                "KATAKANA_2" -> {
                    mainTitle.text = "Katakana Part 2"
                    stylizedNumber.text = "六"
                    KatakanaPartTwoFragment()
                }
                "PRONUNCIATION" -> {
                    mainTitle.text = "Pronunciation"
                    stylizedNumber.text = "七"
                    PronunciationBasicsFragment()
                }
                "READING_BASICS" -> {
                    mainTitle.text = "Reading Basics"
                    stylizedNumber.text = "八"
                    ReadingBasicsFragment()
                }
                else -> {
                    mainTitle.text = "Lesson"
                    HiraganaPartOneFragment() 
                }
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }

        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.nav_lessons

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
                R.id.nav_decks -> {
                    startActivity(Intent(this, CreateFlashcardActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}
