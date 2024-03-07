package com.example.coloredbottles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }
    fun onStartButtonClick(view: View) {
        val intent = Intent(this, DifficultActivity::class.java)
        startActivity(intent)
    }
}