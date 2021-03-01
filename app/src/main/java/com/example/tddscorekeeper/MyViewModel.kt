package com.example.tddscorekeeper

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyViewModel @Inject constructor(val score: Score, val repository: Repository): ViewModel()  {

    var logScore = 0

    private val _highScoreLiveData = MutableLiveData<Int>()
    val highScoreLiveData: LiveData<Int> = _highScoreLiveData

    init {
        loadHighScore()
    }



    private val _scoreLiveData = MutableLiveData<Int>()
    val scoreLiveData: LiveData<Int> = _scoreLiveData

    fun loadHighScore() {
        Log.i("MyTest", "highscore ${repository.loadHighScore()}")
        score.highScore = repository.loadHighScore()
        _highScoreLiveData.value = repository.loadHighScore()
    }

    fun increaseScore() {
        _scoreLiveData.value = score.increaseScore()
        _highScoreLiveData.value = score.checkHighScore()
    }

    fun decreaseScore() {
        _scoreLiveData.value = score.decreaseScore()
    }


}