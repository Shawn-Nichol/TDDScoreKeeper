package com.example.tddscorekeeper

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tddscorekeeper.di.MyApplication
import com.example.tddscorekeeper.storage.SHARED_PREF_KEY
import javax.inject.Inject




class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MyViewModel

    @Inject
    lateinit var viewModel2: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // Ask Dagger to Inject our dependencies
        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.logScore = 4

        Log.i("MyTest", "Scores: ${viewModel.logScore} : ${viewModel2.logScore}")

    }



}