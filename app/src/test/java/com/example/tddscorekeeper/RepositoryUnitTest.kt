package com.example.tddscorekeeper

import com.example.tddscorekeeper.storage.HIGHSCORE_KEY
import com.example.tddscorekeeper.storage.Storage
import com.nhaarman.mockitokotlin2.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryUnitTest {


    lateinit var repository: Repository

    @Mock
    lateinit var storage: Storage

    @Before
    fun setup() {

        repository = Repository(storage)
    }

    @Test
    fun saveScore() {
        val score = 20
        repository.saveScore(20)

        verify(storage).setInt(HIGHSCORE_KEY, score)
    }

    @Test
    fun loadScore() {
        repository.loadHighScore()

        verify(storage).getInt(HIGHSCORE_KEY)
    }


}