package com.example.tddscorekeeper


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId

import com.example.tddscorekeeper.main.MainActivity
import org.junit.Before
import org.junit.Test


class EndToEnd {

    @Before
    fun setup() {

    }

    @Test
    fun test() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main_container)).check(matches(ViewMatchers.isDisplayed()))

    }
}