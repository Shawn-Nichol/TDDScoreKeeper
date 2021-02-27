package com.example.tddscorekeeper.di

import android.content.Context
import com.example.tddscorekeeper.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [StorageModule::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindInstance, the Context passed in will be available in the graph.
        fun create(@BindsInstance context: Context)
    }

    // Classes that can be injected by this component
    fun inject(activity: MainActivity)

}