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
import com.example.tddscorekeeper.main.MyViewModel
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.hamcrest.core.IsNot.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.LooperMode


@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
class MyFragmentUnitTest {

    // Executes tasks in the Architecture Components in the same thread
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var scenario: FragmentScenario<ScoreKeeperFragment>

    private lateinit var viewModel: MyViewModel

    private val mockNavController = mock(NavController::class.java)

    @Before
    fun setup() {
        val myLiveData: MutableLiveData<Int> = MutableLiveData(0)

        viewModel = mock(MyViewModel::class.java)

        `when`(viewModel.scoreLiveData).thenReturn(myLiveData)

        scenario = launchFragmentInContainer(
            factory = MainFragmentFactory(viewModel),
            fragmentArgs = null,
            themeResId = R.style.Theme_TDDScoreKeeper,
            initialState = Lifecycle.State.RESUMED
        )
    }

    @Test
    fun `Button Minus Properties`() {
        val btnMinus = onView(withId(R.id.btn_minus))

        btnMinus
            .check(ViewAssertions.matches(isDisplayed()))
            .check(ViewAssertions.matches(isClickable()))
            .perform(ViewActions.click())
    }

    @Test
    fun `Button Minus clicked`() {
        val btnMinus = onView(withId(R.id.btn_minus))

        btnMinus.perform(ViewActions.click())

        verify(viewModel, times(1)).decreaseScore()
    }

    @Test
    fun `Button Plus properties`() {
        val btnPlus = onView(withId(R.id.btn_plus))

        btnPlus
            .check(ViewAssertions.matches(isDisplayed()))
            .perform(ViewActions.click())
    }

    @Test
    fun `Button Plus clicked`() {
        val btnPlus = onView(withId(R.id.btn_plus))
        btnPlus.perform(ViewActions.click())

        verify(viewModel, times(1)).increaseScore()
    }

    @Test
    fun `TextView Score properties`() {
        val score = R.id.tv_score


        val tvScore = onView(withId(score))

        tvScore.perform(setTextInTextView("0"))

        tvScore
            .check(ViewAssertions.matches(isDisplayed()))
            .check(ViewAssertions.matches(not(isClickable())))
            .check(ViewAssertions.matches(withText("0")))
    }

    @Test
    fun `TextView HighScore properties`() {
        val highScore = onView(ViewMatchers.withId(R.id.tv_highScore))

        highScore.perform(setTextInTextView("7"))

        highScore
            .check(ViewAssertions.matches(isDisplayed()))
            .check(ViewAssertions.matches(not(isClickable())))
            .check(ViewAssertions.matches(withText("7")))
    }

    @Test
    fun `menu reset score`() {

        scenario.onFragment{ fragment ->
            Navigation.setViewNavController(fragment.requireView(), mockNavController)
        }

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
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())
        onView(withText(R.string.menu_reset_high_score))
            .check(ViewAssertions.matches(isDisplayed()))
            .perform(ViewActions.click())

        verify(mockNavController).navigate(R.id.action_dest_scoreKeeperFragment_to_resetHighScoreDialog)
    }


    private fun setTextInTextView(value: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return CoreMatchers.allOf(
                    ViewMatchers.isDisplayed(), ViewMatchers.isAssignableFrom(
                        TextView::class.java
                    )
                )
            }

            override fun perform(uiController: UiController, view: View) {
                (view as TextView).text = value
            }

            override fun getDescription(): String {
                return "replace text"
            }
        }
    }

}

