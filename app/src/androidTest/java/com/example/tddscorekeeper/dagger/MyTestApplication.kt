package com.example.tddscorekeeper.dagger

import com.example.tddscorekeeper.dagger.di.DaggerTestAppComponent
import com.example.tddscorekeeper.di.AppComponent
import com.example.tddscorekeeper.di.MyApplication

class MyTestApplication : MyApplication() {
    override fun initializeComponent(): AppComponent {
        return DaggerTestAppComponent.create()
    }
}