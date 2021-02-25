package com.example.tddscorekeeper

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class ScoreUnitTest {

    lateinit var score: Score

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
    fun increaseScore_highScore() {
        score.currentScore  = 9
        score.highScore = 10
        score.increaseScore()

        Assert.assertEquals(score.highScore, score.currentScore)
    }

    @Test
    fun increaseScore_NotHighScore() {
        score.highScore
        score.highScore = 10

        score.increaseScore()

        Assert.assertEquals(10, score.highScore)
    }

    @Test
    fun myList_size() {
        score.myList.add(5)

        Assert.assertEquals(1, score.myList.size)
    }

    @Test
    fun myList_sizeSpy() {
        val spylist = spy(score.myList)

        spylist.add(2)
        spylist.add(3)

        Assert.assertEquals(2, spylist.size)

    }

    @Test
    fun myList_doReturn() {
        val spyList = spy(score.myList)
        doReturn(2).whenever(spyList).get(0)

        Assert.assertEquals(2, spyList.get(0))
    }
}