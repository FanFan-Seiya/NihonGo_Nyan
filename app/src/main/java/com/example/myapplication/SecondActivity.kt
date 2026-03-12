package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.card.MaterialCardView

class SecondActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private val sliderHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // --- Slideshow Logic ---
        viewPager = findViewById(R.id.viewPagerSlideshow)
        val images = listOf(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5
        )

        viewPager.adapter = SlideshowAdapter(images)
        
        // Smooth transition animation
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        viewPager.setPageTransformer(compositePageTransformer)

        // Auto-slide every 3 seconds
        val sliderRunnable = object : Runnable {
            override fun run() {
                var currentItem = viewPager.currentItem
                currentItem = if (currentItem >= images.size - 1) 0 else currentItem + 1
                viewPager.setCurrentItem(currentItem, true)
                sliderHandler.postDelayed(this, 3000)
            }
        }
        sliderHandler.postDelayed(sliderRunnable, 3000)

        // --- Dashboard Navigation & Button Logic ---
        val createIntent = Intent(this, CreateFlashcardActivity::class.java)
        val alphabetIntent = Intent(this, BasicAlphabetActivity::class.java)
        val lessonIntent = Intent(this, LessonListActivity::class.java)
        val quizIntent = Intent(this, QuizModeActivity::class.java)

        // Flashcards
        findViewById<MaterialCardView>(R.id.cardCreateFlashcard).setOnClickListener { startActivity(createIntent) }
        findViewById<Button>(R.id.btnCreateFlashcard).setOnClickListener { startActivity(createIntent) }
        
        // Basic Alphabet
        findViewById<MaterialCardView>(R.id.cardBasicAlphabet).setOnClickListener { startActivity(alphabetIntent) }
        findViewById<Button>(R.id.btnBasicAlphabet).setOnClickListener { startActivity(alphabetIntent) }

        // Lesson List
        findViewById<MaterialCardView>(R.id.cardLessonList).setOnClickListener { startActivity(lessonIntent) }
        findViewById<Button>(R.id.btnLessonList).setOnClickListener { startActivity(lessonIntent) }
        
        // Quiz Mode
        findViewById<MaterialCardView>(R.id.cardQuizMode).setOnClickListener { startActivity(quizIntent) }
        findViewById<Button>(R.id.btnQuizMode).setOnClickListener { startActivity(quizIntent) }
    }

    override fun onDestroy() {
        super.onDestroy()
        sliderHandler.removeCallbacksAndMessages(null)
    }

    class SlideshowAdapter(private val images: List<Int>) : RecyclerView.Adapter<SlideshowAdapter.ViewHolder>() {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val imageView: ImageView = view.findViewById(R.id.imageView)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slideshow, parent, false)
            return ViewHolder(view)
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.imageView.setImageResource(images[position])
        }
        override fun getItemCount() = images.size
    }
}