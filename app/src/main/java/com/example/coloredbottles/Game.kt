package com.example.coloredbottles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class Game() {
    private var correctly = 0

    fun checkGameState(bottleSequence: ArrayList<Int>, requiredSequence: ArrayList<Int>) : Int{
        return if (bottleSequence == requiredSequence) -1
        else {
            correctly = bottleSequence.zip(requiredSequence).count { (element1, element2) -> element1 == element2 }
            correctly
        }
    }
}