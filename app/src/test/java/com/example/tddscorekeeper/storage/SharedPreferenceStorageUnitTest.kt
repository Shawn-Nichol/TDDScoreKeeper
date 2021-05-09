package com.example.tddscorekeeper.storage

import com.example.tddscorekeeper.FakeStorage
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ScorePreferenceStorageUnitTest {
    private lateinit var sharedPre: FakeStorage

    @Before
    fun setup() {
        sharedPre = FakeStorage()
    }

    @Test
    fun `Get high score`() {
        Assert.assertEquals(5, sharedPre.highScore)
    }

    @Test
    fun `Set high score`() {
        sharedPre.highScore = 8
        Assert.assertEquals(8, sharedPre.highScore)
    }
}