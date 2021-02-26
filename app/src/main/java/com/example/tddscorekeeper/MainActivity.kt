package com.example.tddscorekeeper

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider


val SHARED_PREF_KEY = "SharedPreferences Key"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPreferences = this.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)

        val repository = Repository(sharedPreferences)
        val viewModelFactory: MyViewModelFactory = MyViewModelFactory(repository)
        ViewModelProvider(this, viewModelFactory).get(MyViewModel::class.java)
    }



}