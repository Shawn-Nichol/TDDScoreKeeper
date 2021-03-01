package com.example.tddscorekeeper

import android.app.Application
import android.content.SharedPreferences
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

        verify(storage.setInt(HIGHSCORE_KEY, score))
    }

//    @Mock
//    lateinit var sharedPreferencesEditor: SharedPreferences.Editor
//
//    @Mock
//    lateinit var sharedPreferences: SharedPreferences
//
//    @Mock
//    lateinit var storage: Storage
//
//    lateinit var repository: Repository
//
//
//    @Before
//    fun setup() {
//        whenever(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor)
//        repository = Repository(storage)
//    }
//
//    @Test
//    fun saveScore_toPreference() {
//        val score = 25
//        repository.saveScore(score)
//
//        // saves
//        inOrder(sharedPreferencesEditor)
//            verify(sharedPreferencesEditor).putInt(any(), eq(score))
//            verify(sharedPreferencesEditor).commit()
//    }
//
//    @Test
//    fun loadHighScore() {
//        repository.loadHighScore()
//
//        inOrder(sharedPreferences)
//        verify(sharedPreferences).getInt(any(), any())
//
//
//    }
}