package com.example.tddscorekeeper


import com.example.tddscorekeeper.storage.HIGHSCORE_KEY
import com.example.tddscorekeeper.storage.Storage

import javax.inject.Inject


class Repository @Inject constructor(private val storage: Storage) {

    fun saveScore(highScore: Int) {
        storage.setInt(HIGHSCORE_KEY, highScore)
    }

    fun loadHighScore(): Int {
        return storage.getInt(HIGHSCORE_KEY)
    }
}