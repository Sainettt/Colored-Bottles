package com.example.coloredbottles

import android.content.Intent
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    private var rows: Int = 2
    private var columns: Int = 2
    private val grid: Grid by lazy { Grid(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val pauseButton = findViewById<ImageView>(R.id.pauseButton)

        val gridLayout = findViewById<GridLayout>(R.id.grid)
        val difficulty = intent.getIntExtra("difficulty", 4)

        rows = when (difficulty) {
            4 -> 2
            6 -> 2
            9 -> 3
            else -> 2
        }

        columns = when (difficulty) {
            4 -> 2
            6 -> 3
            9 -> 3
            else -> 2
        }

            val createdGrid = grid.setupGridLayout(gridLayout, rows, columns)
            val requiredSequence = grid.generateSequence(rows,columns)

        pauseButton.setOnClickListener {
            val intent = Intent(this, PauseActivity::class.java)
            intent.putExtra("difficulty", difficulty)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
    }
}