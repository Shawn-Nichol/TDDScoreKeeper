package com.example.tddscorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // ViewModel need to pass in the repsositor will need a factory for this.
        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
    }
}