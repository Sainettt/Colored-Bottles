package com.example.coloredbottles

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class DifficultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficult_select)

        val easyButton = findViewById<LinearLayout>(R.id.easyGame)
        val medium = findViewById<LinearLayout>(R.id.mediumGame)
        val hard = findViewById<LinearLayout>(R.id.hardGame)

        val onClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.easyGame -> startGameActivity("easy")
                R.id.mediumGame -> startGameActivity("medium")
                R.id.hardGame-> startGameActivity("hard")
            }
        }
        easyButton.setOnClickListener(onClickListener)
        medium.setOnClickListener(onClickListener)
        hard.setOnClickListener(onClickListener)
    }
    private fun startGameActivity(difficulty: String){
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("difficulty", difficulty)
        startActivity(intent)
    }
}