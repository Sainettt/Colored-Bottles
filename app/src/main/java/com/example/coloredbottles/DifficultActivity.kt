package com.example.coloredbottles

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class DifficultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficult_select)

        val easyButton = findViewById<LinearLayout>(R.id.easyGame)
        val mediumButton = findViewById<LinearLayout>(R.id.mediumGame)
        val hardButton = findViewById<LinearLayout>(R.id.hardGame)

        val onClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.easyGame -> startGameActivity(4)
                R.id.mediumGame -> startGameActivity(6)
                R.id.hardGame-> startGameActivity(9)
            }
        }
        easyButton.setOnClickListener(onClickListener)
        mediumButton.setOnClickListener(onClickListener)
        hardButton.setOnClickListener(onClickListener)
    }
    private fun startGameActivity(bottlesCount:Int){
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("difficulty", bottlesCount)
        startActivity(intent)
    }
}