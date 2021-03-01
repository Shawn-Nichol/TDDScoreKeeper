package com.example.tddscorekeeper

import javax.inject.Inject


class Score @Inject constructor()  {

    var highScore = 0
    var currentScore = 0

    fun increaseScore(): Int {
        currentScore++
        return currentScore
    }

    fun checkHighScore(): Int {
        if(currentScore > highScore) {
            highScore = currentScore
        }

        return highScore
    }

    fun decreaseScore(): Int {
       if(currentScore != 0) {
           currentScore--
       }
        return currentScore
    }

    val myList: MutableList<Int> = mutableListOf()
}