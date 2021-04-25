package com.example.tddscorekeeper.dagger.di

import com.example.tddscorekeeper.FakeStorage
import com.example.tddscorekeeper.storage.Storage
import dagger.Binds
import dagger.Module

// Overrides storageModule in Android tests.
@Module
abstract class TestStorageModule {
    // Makes Dagger provide fakeStorage when a storage type is requested
    @Binds
    abstract fun provideStorage(storage: FakeStorage): Storage
}