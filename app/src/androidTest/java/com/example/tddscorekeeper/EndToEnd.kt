package com.example.tddscorekeeper


import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*

import com.example.tddscorekeeper.main.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Test


class EndToEnd {


    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)

    }

    @After
    fun close() {

        scenario
            .onActivity {
                it.viewModel.resetHighScore(5)
                it.viewModel.resetScore()
            }
            .close()
    }

    @Test
    fun loadActivity() {
        onView(withId(R.id.main_container)).check(matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun loadFragment() {
        onView(withId(R.id.dest_scoreKeeperFragment))
    }

    @Test
    fun loadFakeHighScore() {
        onView(withId(R.id.tv_highScore))
            .check(matches(isDisplayed()))
            .check(matches(withText("High Score: 5")))
    }

    @Test
    fun newHighScore() {
        // Must be higher than 5, set in the fake repository
        val highScore = 6
        multiplePlusButtonPresses(highScore)

        onView(withId(R.id.tv_highScore)).check(matches(withText("High Score: $highScore")))
    }

    @Test
    fun minScoreZero() {
        var btnPresses = 3
        multiplePlusButtonPresses(btnPresses)

        while (btnPresses > -2) {
            onView(withId(R.id.btn_minus)).perform(click())
            btnPresses--

            if(btnPresses <= 0) {
                onView(withId(R.id.tv_score)).check(matches(withText("0")))
            } else {
                onView(withId(R.id.tv_score)).check(matches(withText(btnPresses.toString())))
            }
        }

    }

    @Test
    fun resetScore() {
        val btnPresses = 3
        multiplePlusButtonPresses(btnPresses)

        onView(withId(R.id.tv_score)).check(matches(withText("3")))

        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())

        onView(withText(R.string.reset_score)).perform(click())

        onView(withId(R.id.tv_score)).check(matches(withText("0")))

    }

    @Test
    fun resetHighScore() {
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())
        onView(withText(R.string.reset_high_score)).perform(click())
        onView(withId(R.id.tv_highScore)).check(matches(withText("High Score: 0")))
    }

    private fun multiplePlusButtonPresses(btnPresses: Int) {
        var pressCounter = 0

        while (pressCounter < btnPresses) {
            onView(withId(R.id.btn_plus)).perform(click())
            pressCounter++
            onView(withId(R.id.tv_score)).check(matches(withText(pressCounter.toString())))
        }
    }

}