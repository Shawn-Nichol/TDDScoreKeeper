package com.example.tddscorekeeper

import android.app.Application
import android.content.SharedPreferences
import com.nhaarman.mockitokotlin2.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryUnitTest {


    @Mock
    lateinit var sharedPreferencesEditor: SharedPreferences.Editor

    @Mock
    lateinit var sharedPreferences: SharedPreferences

    lateinit var repository: Repository


    @Before
    fun setup() {
        whenever(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor)
        repository = Repository(sharedPreferences)
    }

    @Test
    fun saveScore_toPreference() {
        val score = 25
        repository.saveScore(score)

        // saves
        inOrder(sharedPreferencesEditor)
            verify(sharedPreferencesEditor).putInt(any(), eq(score))
            verify(sharedPreferencesEditor).commit()
    }

    @Test
    fun loadHighScore() {
        repository.loadHighScore()

        inOrder(sharedPreferences)
        verify(sharedPreferences).getInt(any(), any())


    }
}