package com.example.tddscorekeeper


import com.example.tddscorekeeper.storage.HIGH_SCORE_KEY
import com.example.tddscorekeeper.storage.Storage

import javax.inject.Inject


class Repository @Inject constructor(private val storage: Storage) {

    fun saveScore(highScore: Int) {
        storage.setInt(HIGH_SCORE_KEY, highScore)
    }

    fun loadHighScore(): Int {
        return storage.getInt(HIGH_SCORE_KEY)
    }
}