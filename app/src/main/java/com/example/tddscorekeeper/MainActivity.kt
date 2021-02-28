package com.example.tddscorekeeper


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tddscorekeeper.di.MyApplication

import javax.inject.Inject




class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MyViewModel

    @Inject
    lateinit var viewModel2: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.increaseScore()
        viewModel.myScore = 4



        Log.i("MyTEST", "Numbers match ${viewModel.myScore} : ${viewModel2.myScore}" )

    }



}