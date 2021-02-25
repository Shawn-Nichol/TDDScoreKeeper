package com.example.tddscorekeeper

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ViewModelUnitTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var highScoreObserver: Observer<Int>


    private lateinit var currentScoreObserver: Observer<Int>

    private lateinit var viewModel: MyViewModel

    @Before
    fun setup() {
        viewModel = MyViewModel(repository)

        currentScoreObserver = mock()

        viewModel.highScoreLiveData.observeForever(highScoreObserver)
        viewModel.scoreLiveData.observeForever(currentScoreObserver)



    }

    @Test
    fun highScore() {
        //given: Setup objects

        // When do the action
        whenever(repository.loadHighScore()).thenReturn(10)

         viewModel.highScore()

        // Then check what happens

        // Ensure that loadHighScore() is called.
        verify(repository).loadHighScore()
        verify(highScoreObserver).onChanged(any())
        // Check the value.
        Assert.assertEquals(10, viewModel.highScoreLiveData.value)
    }

    @Test
    fun increaseScore() {
        // given: setup object

        // When: do action
        viewModel.increaseScore()

        // Then results
        verify(currentScoreObserver).onChanged(1)
        Assert.assertEquals(1, viewModel.score.currentScore)
    }

    @Test
    fun increaseScore_LiveData(){
        viewModel.increaseScore()
        viewModel.increaseScore()
        viewModel.increaseScore()

        verify(currentScoreObserver).onChanged(3)
        Assert.assertEquals(3, viewModel.scoreLiveData.value)
    }

    @Test
    fun increasesScore_ThreeTimes() {
        // When: do action
        viewModel.increaseScore()
        viewModel.increaseScore()
        viewModel.increaseScore()

        // Then results
        Assert.assertEquals(3, viewModel.score.currentScore)
    }

    @Test
    fun increaseScore_NewHighScore() {

        // When: do action
        viewModel.score.currentScore = 10
        viewModel.increaseScore()
        // Then results
        verify(highScoreObserver).onChanged(11)
        Assert.assertEquals(11, viewModel.scoreLiveData.value)
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
        // When: do action
        viewModel.score.currentScore = 8
        viewModel.decreaseScore()

        // Then results
        Assert.assertEquals(7, viewModel.scoreLiveData.value)
    }
}