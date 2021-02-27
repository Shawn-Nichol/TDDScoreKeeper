package com.example.tddscorekeeper.storage

import android.content.Context

import javax.inject.Inject


const val SHARED_PREF_KEY = "SharedPreferences Key"
const val HIGHSCORE_KEY = "SharedPreference high score"

class SharedPreferenceStorage @Inject constructor(context: Context) :Storage{
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)

    override fun setInt(key: String, value: Int) {
        with(sharedPreferences.edit()) {
            putInt(key, value)
            apply()
        }
    }

    override fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 10)
    }


}