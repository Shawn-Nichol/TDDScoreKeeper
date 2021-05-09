package com.example.tddscorekeeper

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class ScoreUnitTest {

    private lateinit var score: Score

    @Before
    fun setup() {
        score = Score()
    }

    @Test
    fun increaseScore() {
        score.increaseScore()
        Assert.assertEquals(1, score.currentScore)
    }

    @Test
    fun decreaseScore() {
        score.currentScore = 5
        score.decreaseScore()
        Assert.assertEquals(4, score.currentScore)
    }

    @Test
    fun decreaseScore_minZero() {
        score.decreaseScore()
        Assert.assertEquals(0, 0)
    }

    @Test
    fun checkHighScore_staysTheSame() {
        // get objects
        score.currentScore = 9
        score.highScore = 10

        // When: do action
        score.checkHighScore()

        // Then results
        Assert.assertEquals(10, score.highScore)
        Assert.assertNotEquals(10, score.currentScore)
    }

    @Test
    fun checkHigh_increase() {
        // get objects
        score.currentScore = 11
        score.highScore = 10

        // When do action
        score.checkHighScore()

        // then results
        Assert.assertEquals(11, score.highScore)
        Assert.assertEquals(11, score.currentScore)

    }

}