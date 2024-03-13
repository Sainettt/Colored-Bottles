package com.example.coloredbottles

import android.content.Context
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.Toast

class Grid(context: Context) : GridLayout(context) {


    fun setupGridLayout(gridLayout: GridLayout, rows: Int, columns: Int) : ArrayList<Int> {

        gridLayout.removeAllViews()
        gridLayout.rowCount = rows
        gridLayout.columnCount = columns

        val bottleSequence = generateSequence(rows,columns)

        val marginSize = resources.getDimensionPixelSize(R.dimen.bottle_margin)
        val bottleWidth = resources.getDimensionPixelSize(R.dimen.bottle_width)
        val bottleHeight = resources.getDimensionPixelSize(R.dimen.bottle_height)

        for (i in 0 until rows * columns) {
            val bottle = ImageView(context)
            bottle.layoutParams = LayoutParams().apply {
                width = bottleWidth
                height = bottleHeight
                columnSpec = spec(UNDEFINED, FILL, 1f)
                rowSpec = spec(UNDEFINED, FILL, 1f)
            }

            bottle.setPadding(marginSize, marginSize, marginSize, marginSize)

            bottle.setImageResource(bottleSequence[i])
            bottle.setOnClickListener {
                Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
            }
            gridLayout.addView(bottle)
        }
        return bottleSequence
    }
     fun generateSequence(rows: Int, columns: Int): ArrayList<Int> {
        val bottleImages = allBottles()
        val bottleSequence = ArrayList<Int>(rows * columns)
        for (i in 0 until rows * columns) {
            val randomIndex = (Math.random() * bottleImages.size).toInt()
            bottleSequence.add(bottleImages[randomIndex])
            bottleImages.removeAt(randomIndex)
        }
        return ArrayList(bottleSequence)
    }

    private fun allBottles(): ArrayList<Int> {
        return arrayListOf(
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
    }

}