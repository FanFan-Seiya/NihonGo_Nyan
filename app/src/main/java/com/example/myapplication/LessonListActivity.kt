package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * GUIDE FOR ADDING NEW LESSONS:
 *
 * 1. CREATE LAYOUT: Create 'res/layout/fragment_lesson_name.xml'.
 *    Copy the ScrollView structure from an existing lesson fragment.
 *
 * 2. CREATE FRAGMENT: Create a new Fragment class (e.g., 'LessonNameLessonTitleFragment.kt')
 *    that inflates your new layout.
 *
 * 3. REGISTER IN CONTENT ACTIVITY: Go to 'LessonContentActivity.kt' and add
 *    a new branch to the 'when (lessonId)' block. This is where you set the
 *    toolbar title and return your new Fragment instance.
 *
 *
 * 4. ADD BUTTON HERE: In this file (LessonListActivity), find your button
 *    and set an OnClickListener to start 'LessonContentActivity' with
 *    intent.putExtra("LESSON_ID", "YOUR_CONSTANT_ID").
 *
 * NAMING CONVENTIONS:
 * - Layouts: fragment_lesson_hiragana_part_two.xml
 * - Fragments: HiraganaPartTwoFragment.kt
 * - Lesson IDs: "HIRAGANA_2", "PARTICLES", etc.
 */
class LessonListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_list)

        // Setup Study Buttons
        findViewById<Button>(R.id.btnStartLesson1).setOnClickListener {
            val intent = Intent(this, LessonContentActivity::class.java)
            intent.putExtra("LESSON_ID", "HIRAGANA_1")
            startActivity(intent)
        }
        
        findViewById<Button>(R.id.btnStartLesson2).setOnClickListener {
            val intent = Intent(this, LessonContentActivity::class.java)
            intent.putExtra("LESSON_ID", "HIRAGANA_2")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnStartLesson3).setOnClickListener {
            val intent = Intent(this, LessonContentActivity::class.java)
            intent.putExtra("LESSON_ID", "HIRAGANA_3")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnStartLessonSpecial).setOnClickListener {
            val intent = Intent(this, LessonContentActivity::class.java)
            intent.putExtra("LESSON_ID", "SPECIAL_CHARS")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnStartLessonKatakana).setOnClickListener {
            val intent = Intent(this, LessonContentActivity::class.java)
            intent.putExtra("LESSON_ID", "KATAKANA_1")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnStartLessonKatakana2).setOnClickListener {
            val intent = Intent(this, LessonContentActivity::class.java)
            intent.putExtra("LESSON_ID", "KATAKANA_2")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnStartLessonPron).setOnClickListener {
            val intent = Intent(this, LessonContentActivity::class.java)
            intent.putExtra("LESSON_ID", "PRONUNCIATION")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnStartLessonReading).setOnClickListener {
            val intent = Intent(this, LessonContentActivity::class.java)
            intent.putExtra("LESSON_ID", "READING_BASICS")
            startActivity(intent)
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
                R.id.nav_lessons -> true
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
