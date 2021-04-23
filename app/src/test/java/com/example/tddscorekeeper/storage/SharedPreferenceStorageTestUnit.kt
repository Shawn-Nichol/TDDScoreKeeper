package com.example.tddscorekeeper.storage

import android.content.Context
import com.example.tddscorekeeper.storage.SharedPreferenceStorage
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ScorePreferenceStorageUnitTest {

    lateinit var sharedPre: SharedPreferenceStorage

    var context: Context = mock(Context::class.java)


    @Before
    fun setup() {
        sharedPre = SharedPreferenceStorage(context)
    }

    @Test
    fun setInt() {

    }
}