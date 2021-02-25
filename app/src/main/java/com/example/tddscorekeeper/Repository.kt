package com.example.tddscorekeeper

import android.content.SharedPreferences

class Repository(private val sharedPreferences: SharedPreferences) {

    fun saveScore(highScore: Int) {
        with(sharedPreferences.edit()) {
            putInt("High Score", highScore)

            commit()
        }
    }

    fun loadHighScore(): Int {
        return sharedPreferences.getInt("High Score", 10)
    }
}