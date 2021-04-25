package com.example.tddscorekeeper

import com.example.tddscorekeeper.storage.Storage
import javax.inject.Inject

class FakeStorage @Inject constructor() : Storage{

    var highScore = 10

    override fun setInt(key: String, value: Int) {
        highScore = value
    }

    override fun getInt(key: String): Int {
        return highScore
    }
}