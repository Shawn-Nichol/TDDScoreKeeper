package com.example.tddscorekeeper.dagger.di

import com.example.tddscorekeeper.di.AppComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestStorageModule::class])
interface TestAppComponent : AppComponent {
}