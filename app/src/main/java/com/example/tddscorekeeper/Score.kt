package com.example.tddscorekeeper

import javax.inject.Inject


class Score @Inject constructor()  {

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