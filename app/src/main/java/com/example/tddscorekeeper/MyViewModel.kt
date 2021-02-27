package com.example.tddscorekeeper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MyViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    val score = Score()



    private val _highScoreLiveData = MutableLiveData<Int>()
    val highScoreLiveData: LiveData<Int> = _highScoreLiveData

    private val _scoreLiveData = MutableLiveData<Int>()
    val scoreLiveData: LiveData<Int> = _scoreLiveData

    fun highScore() {
        _highScoreLiveData.value = repository.loadHighScore()
    }

    fun increaseScore() {
        score.increaseScore()
        _scoreLiveData.value = score.currentScore
        _highScoreLiveData.value = score.highScore
    }

    fun decreaseScore() {
        score.decreaseScore()
        _scoreLiveData.value = score.currentScore
    }

}