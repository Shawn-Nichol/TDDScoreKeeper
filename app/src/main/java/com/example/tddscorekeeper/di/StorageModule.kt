package com.example.tddscorekeeper.di

import android.content.SharedPreferences
import com.example.tddscorekeeper.storage.SharedPreferenceStorage
import com.example.tddscorekeeper.storage.Storage
import dagger.Binds
import dagger.Module

/**
 * Tells dagger its a module.
 */
@Module
abstract class StorageModule {

    // Makes Dagger provide SharedPreferenceStorage when a storage type is requested
    @Binds
    abstract fun provideStorage(storage: SharedPreferenceStorage): Storage
}