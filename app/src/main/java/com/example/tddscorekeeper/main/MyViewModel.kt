package com.example.tddscorekeeper.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tddscorekeeper.Repository
import com.example.tddscorekeeper.Score
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyViewModel @Inject constructor(private val score: Score, private val repository: Repository): ViewModel()  {



    private val _highScoreLiveData = MutableLiveData<Int>()
    val highScoreLiveData: LiveData<Int> = _highScoreLiveData

    private val _scoreLiveData = MutableLiveData<Int>()
    val scoreLiveData: LiveData<Int> = _scoreLiveData

    init {
        loadHighScore()
    }

    fun loadHighScore() {
        Log.i("MyTest", "highscore ${repository.loadHighScore()}")
        val savedHighScore = repository.loadHighScore()

        score.highScore = savedHighScore
        _highScoreLiveData.value = savedHighScore
    }

    fun increaseScore() {
        _scoreLiveData.value = score.increaseScore()
        _highScoreLiveData.value = score.checkHighScore()
    }

    fun decreaseScore() {
        _scoreLiveData.value = score.decreaseScore()
    }




}