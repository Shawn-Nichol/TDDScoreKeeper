package com.example.tddscorekeeper.main

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.tddscorekeeper.R
import org.junit.*
import org.junit.runner.RunWith

import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class MainActivityUnitTest {





    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
         scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
    }


    @After
    fun close() {
        scenario.close()
    }

    @Test
    fun `Root Element of the main layout`() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }




}