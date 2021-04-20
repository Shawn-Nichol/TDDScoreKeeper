package com.example.tddscorekeeper.di

import android.content.Context
import com.example.tddscorekeeper.main.MainActivity
import com.example.tddscorekeeper.main.fragment.ScoreKeeperFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Classes that can be injected by this component
    fun inject(activity: MainActivity)
    fun inject(fragment: ScoreKeeperFragment)

}