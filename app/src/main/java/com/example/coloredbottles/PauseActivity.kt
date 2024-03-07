package com.example.coloredbottles

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PauseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pause_game)

        val resumeButton = findViewById<Button>(R.id.resume_button)
        val restartButton = findViewById<Button>(R.id.restart_button)
        val quitButton = findViewById<Button>(R.id.quit_button)

        val onClickListener = View.OnClickListener { view ->
            when (view.id){
                R.id.resume_button -> {
                    val intent = Intent(this, GameActivity::class.java)
                    startActivity(intent)
                }
                R.id.restart_button -> {
                    val intent = Intent(this, GameActivity::class.java)
                    startActivity(intent)
                }
                R.id.quit_button -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        resumeButton.setOnClickListener(onClickListener)
        restartButton.setOnClickListener(onClickListener)
        quitButton.setOnClickListener(onClickListener)
    }

}