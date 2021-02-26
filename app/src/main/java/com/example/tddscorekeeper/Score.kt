package com.example.tddscorekeeper

class Score {

    var highScore = 0
    var currentScore = 0

    fun increaseScore() {
        currentScore++
        if(currentScore > highScore) {
            highScore = currentScore
        }
    }

    fun decreaseScore() {
       if(currentScore == 0) return
        currentScore--
    }

    val myList: MutableList<Int> = mutableListOf()
}