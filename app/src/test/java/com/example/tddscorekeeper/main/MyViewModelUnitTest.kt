package com.example.tddscorekeeper.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.tddscorekeeper.Repository
import com.example.tddscorekeeper.Score
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ViewModelUnitTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: MyViewModel

    @Mock
    private lateinit var score: Score
    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var highScoreObserver: Observer<Int>

    @Mock
    private lateinit var currentScoreObserver: Observer<Int>


    @Before
    fun setup() {
        score = mock(Score::class.java)
        repository = mock(Repository::class.java)

        viewModel = MyViewModel(score, repository)

        viewModel.highScoreLiveData.observeForever(highScoreObserver)
        viewModel.scoreLiveData.observeForever(currentScoreObserver)

    }


    @Test
    fun increaseScore_functionCalls() {
        // given: setup object

        // When: do action
        viewModel.increaseScore()

        // Then results
        verify(currentScoreObserver).onChanged(any())
        inOrder(score) {
            verify(score).increaseScore()
            verify(score).checkHighScore()
        }
    }

    @Test
    fun increaseScore_ToOne() {
        // Given: setup
        whenever(score.increaseScore()).thenReturn(1)
        // When: do action
        viewModel.increaseScore()
        // Then results
        verify(currentScoreObserver).onChanged(1)
        Assert.assertEquals(1, viewModel.scoreLiveData.value)
    }

    @Test
    fun increaseScore_LiveData() {
        // Given Setup
        whenever(score.increaseScore()).thenReturn(1)


        // When: Do action
        viewModel.increaseScore()
        whenever(score.increaseScore()).thenReturn(2)
        viewModel.increaseScore()
        whenever(score.increaseScore()).thenReturn(3)
        viewModel.increaseScore()

        // Then result.
        verify(currentScoreObserver).onChanged(2)
        verify(score, times(3)).increaseScore()
        Assert.assertEquals(3, viewModel.scoreLiveData.value)
    }


    @Test
    fun loadHighScore() {
        // Given: Setup
        whenever(repository.loadHighScore()).thenReturn(10)
        // When do action
        viewModel.loadHighScore()

        // Then: results
        verify(repository, times(2)).loadHighScore()
        verify(highScoreObserver).onChanged(10)
        Assert.assertEquals(10, viewModel.highScoreLiveData.value)
    }

    @Test
    fun highScore_inCrease() {
        // Given
        whenever(repository.loadHighScore()).thenReturn(10)
        whenever(score.increaseScore()).thenReturn(11)
        whenever(score.checkHighScore()).thenReturn(11)
        // When
        viewModel.loadHighScore()
        viewModel.increaseScore()
        // Then:
        verify(currentScoreObserver).onChanged(11)
        verify(highScoreObserver).onChanged(11)
        Assert.assertEquals(11, viewModel.highScoreLiveData.value)

    }

    @Test
    fun decreaseScore_functionCall() {
        viewModel.decreaseScore()

        inOrder(score) {
            verify(score).decreaseScore()
        }
    }

    @Test
    fun decreaseScore_minZero() {
        // When: do action
        viewModel.decreaseScore()

        // Then results
        Assert.assertEquals(0, viewModel.scoreLiveData.value)
    }

    @Test
    fun decreaseScore() {
        viewModel.score.currentScore = 8
        whenever(score.decreaseScore()).thenReturn(7)
        // When: do action

        viewModel.decreaseScore()

        // Then results
        Assert.assertEquals(7, viewModel.scoreLiveData.value)
    }


}