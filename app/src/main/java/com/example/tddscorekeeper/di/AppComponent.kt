package com.example.tddscorekeeper.di

import android.content.Context
import com.example.tddscorekeeper.MainActivity
import com.example.tddscorekeeper.ScoreKeeperFragment
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent {



    // Classes that can be injected by this component
    fun inject(activity: MainActivity)
    fun inject(fragment: ScoreKeeperFragment)

}