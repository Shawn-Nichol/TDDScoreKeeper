package com.example.tddscorekeeper.main

import android.view.View
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tddscorekeeper.R
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun close() {
        scenario.close()
    }

    @Test
    fun activityLoaded() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun fragmentLoaded() {
        onView(withId(R.id.scoreKeeperFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun views() {
        onView(withId(R.id.btn_plus)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_minus)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_highScore))
            .check(matches(isDisplayed()))
            .check(matches(withText("10")))

        onView(withId(R.id.tv_score))
            .check(matches(isDisplayed()))
            .check(matches(withText("0")))



    }

    @Test
    fun increaseScore() {

        val tvScore = onView(withId(R.id.tv_score))
        val btnClick = onView(withId(R.id.btn_plus))


        tvScore.check(matches(withText("0")))

        btnClick.perform(ViewActions.click())
        tvScore.check(matches(withText("1")))

        btnClick.perform(ViewActions.click())
        tvScore.check(matches(withText("2")))

        var i = 1
        while ( i <= 9) {
            btnClick.perform(ViewActions.click())
            i++
        }

        tvScore.check(matches(withText("11")))

        onView(withId(R.id.tv_highScore)).check(matches(withText("11")))

    }



}