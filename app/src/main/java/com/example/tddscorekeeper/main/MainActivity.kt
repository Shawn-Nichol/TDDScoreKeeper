package com.example.tddscorekeeper.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.di.MyApplication
import com.example.tddscorekeeper.main.fragment.MainFragmentFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        // Ask Dagger to Inject our dependencies
        (application as MyApplication).appComponent.inject(this)
        supportFragmentManager.fragmentFactory = MainFragmentFactory(viewModel)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStop() {
        super.onStop()
        viewModel.saveHighScore()
    }
}