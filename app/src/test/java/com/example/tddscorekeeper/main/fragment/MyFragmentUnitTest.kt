package com.example.tddscorekeeper.main.fragment

import android.view.View
import android.widget.TextView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.main.MainViewModel
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.hamcrest.core.IsNot.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.LooperMode


@RunWith(RobolectricTestRunner::class)
class MyFragmentUnitTest {

    // Executes tasks in the Architecture Components in the same thread
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var scenario: FragmentScenario<ScoreKeeperFragment>

    private var viewModel: MainViewModel = mock(MainViewModel::class.java)

    private val mockNavController = mock(NavController::class.java)


    @Before
    fun setup() {

        scenario = launchFragmentInContainer(
            factory = MainFragmentFactory(viewModel),
            fragmentArgs = null,
            themeResId = R.style.Theme_TDDScoreKeeper,
            initialState = Lifecycle.State.RESUMED
        )

    }

    @After
    fun close() {

    }

    @Test
    fun `Button Minus Properties`() {
        onView(withId(R.id.btn_minus))
            .check(ViewAssertions.matches(isDisplayed()))
            .check(ViewAssertions.matches(isClickable()))
            .perform(ViewActions.click())
    }

    @Test
    fun `Button Minus clicked`() {
        onView(withId(R.id.btn_minus))
            .perform(ViewActions.click())

        verify(viewModel, times(1)).decreaseScore()
    }

    @Test
    fun `Button Plus properties`() {
        onView(withId(R.id.btn_plus))
            .check(ViewAssertions.matches(isDisplayed()))
            .perform(ViewActions.click())
    }

    @Test
    fun `Button Plus clicked`() {
        onView(withId(R.id.btn_plus))
            .perform(ViewActions.click())

        verify(viewModel, times(1)).increaseScore()

    }

    @Test
    fun `TextView Score properties`() {
        onView(withId(R.id.tv_score))
            .check(ViewAssertions.matches(isDisplayed()))
            .check(ViewAssertions.matches(not(isClickable())))
    }

    @Test
    fun `TextView HighScore properties`() {
        onView(withId(R.id.tv_highScore))
            .check(ViewAssertions.matches(isDisplayed()))
            .check(ViewAssertions.matches(not(isClickable())))
    }

    @Test
    fun `menu reset score`() {
        scenario.onFragment{ fragment ->
            Navigation.setViewNavController(fragment.requireView(), mockNavController)
        }

        // Open menu.
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())

        // Menu items need to reference the view with a string, ID doesn't work.
        onView(withText(R.string.menu_reset_score))
            .check(ViewAssertions.matches(isDisplayed()))
            .perform(ViewActions.click())

        verify(mockNavController).navigate(R.id.action_scoreKeeperFragment_to_resetScoreDialog)

    }

    @Test
    fun `menu reset high score`() {
        scenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), mockNavController)
        }

        // Open menu
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())

        onView(withText(R.string.menu_reset_high_score))
            .check(ViewAssertions.matches(isDisplayed()))
            .perform(ViewActions.click())

        verify(mockNavController).navigate(R.id.action_dest_scoreKeeperFragment_to_resetHighScoreDialog)
    }
}

