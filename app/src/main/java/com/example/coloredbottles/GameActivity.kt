package com.example.coloredbottles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutId = when (intent.getStringExtra("difficulty")){
            "easy" -> R.layout.activity_esay_game
            "medium" -> R.layout.activity_medium_game
            "hard" -> R.layout.activity_hard_game
            else -> R.layout.activity_main_menu
        }
        setContentView(layoutId)

        val pauseButton = findViewById<ImageView>(R.id.pauseButton)
        pauseButton.setOnClickListener{
            val intent = Intent(this, PauseActivity::class.java)
            startActivity(intent)
        }
    }
}