package com.example.tddscorekeeper.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.Repository
import com.example.tddscorekeeper.di.MyApplication
import com.example.tddscorekeeper.main.fragment.MainFragmentFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MyViewModel

    @Inject
    lateinit var repository: Repository

    public override fun onCreate(savedInstanceState: Bundle?) {

        // Ask Dagger to Inject our dependencies
        (application as MyApplication).appComponent.inject(this)
        supportFragmentManager.fragmentFactory = MainFragmentFactory(viewModel)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onStop() {
        super.onStop()
        val saveScore: Int = viewModel.highScoreLiveData.value!!
        Log.i("MyTest", "MainActivityOnStop() savescore: $saveScore")
        repository.saveScore(saveScore)

    }
}