package com.example.tddscorekeeper


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tddscorekeeper.di.DaggerAppComponent

import javax.inject.Inject




class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.create().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.increaseScore()


    }



}