package com.example.tddscorekeeper.storage

/**
 * Interface for storage so that double/fake sharedpreference can be used in testing.
 */
interface Storage {
    fun setInt(key: String, value: Int)
    fun getInt(key: String): Int
}