package com.example.tddscorekeeper.di

import android.app.Application
import com.example.tddscorekeeper.di.DaggerAppComponent

class MyApplication : Application() {
        //val appComponent = DaggerAppComponent.create()
        val appComponent: AppComponent by lazy {
                DaggerAppComponent.factory().create(applicationContext)
        }

}