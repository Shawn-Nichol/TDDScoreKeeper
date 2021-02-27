package com.example.tddscorekeeper

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tddscorekeeper.di.MyApplication
import com.example.tddscorekeeper.storage.SHARED_PREF_KEY
import javax.inject.Inject




class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // Ask Dagger to Inject our dependencies
        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val sharedPreferences = this.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)

//        val repository = Repository(sharedPreferences)
//        val viewModelFactory: MyViewModelFactory = MyViewModelFactory(repository)

       // viewModel = ViewModelProvider(this, viewModelFactory).get(MyViewModel::class.java)


    }



}