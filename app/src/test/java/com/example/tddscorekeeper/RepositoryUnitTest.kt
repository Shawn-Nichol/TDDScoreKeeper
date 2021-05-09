package com.example.tddscorekeeper

import com.example.tddscorekeeper.storage.HIGH_SCORE_KEY
import com.example.tddscorekeeper.storage.Storage
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryUnitTest {


    private lateinit var repository: Repository

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

        verify(storage).setInt(HIGH_SCORE_KEY, score)
    }

    @Test
    fun loadScore() {
        repository.loadHighScore()

        verify(storage).getInt(HIGH_SCORE_KEY)
    }


}