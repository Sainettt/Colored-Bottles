package com.example.coloredbottles

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding

class GameActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val gridLayout = findViewById<GridLayout>(R.id.grid)
        val difficulty = intent.getIntExtra("difficulty", 4)

        val rows = when (difficulty) {
            4 -> 2
            6 -> 2
            9 -> 3
            else -> 2
        }

        val columns = when (difficulty) {
            4 -> 2
            6 -> 3
            9 -> 3
            else -> 2
        }

        setupGridLayout(gridLayout, rows, columns)

    }
    private fun setupGridLayout(gridLayout: GridLayout, rows: Int, columns: Int) : ArrayList<Int>{
        gridLayout.rowCount = rows
        gridLayout.columnCount = columns
        val bottleSequence: ArrayList<Int> = arrayListOf(rows*columns)

        val bottleImages = arrayListOf(
            R.drawable.ic_blue_bottle,
            R.drawable.ic_darkblue_bottle,
            R.drawable.ic_green_bottle,
            R.drawable.ic_lime_bottle,
            R.drawable.ic_orange_bottle,
            R.drawable.ic_pink_bottle,
            R.drawable.ic_purple_bottle,
            R.drawable.ic_red_bottle,
            R.drawable.ic_yellow_bottle
        )

        val marginSize = resources.getDimensionPixelSize(R.dimen.bottle_margin)
        val bottleWidth = resources.getDimensionPixelSize(R.dimen.bottle_width)
        val bottleHeight = resources.getDimensionPixelSize(R.dimen.bottle_height)

        for (i in 0 until rows*columns) {
            val bottle = ImageView(this)
            bottle.layoutParams = GridLayout.LayoutParams().apply {
                width = bottleWidth
                height = bottleHeight
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f)
                rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f)
            }

            bottle.setPadding(marginSize,marginSize,marginSize,marginSize)

            val randomIndex = (Math.random() * bottleImages.size).toInt()
            bottleSequence.add(bottleImages[randomIndex])
            bottle.setImageResource(bottleImages[randomIndex])
            bottleImages.removeAt(randomIndex)
            bottle.setOnClickListener {
                Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
            }
            gridLayout.addView(bottle)
        }
        return bottleSequence
    }
    fun onPauseButtonClick (view: View){

    }
}