package com.example.tddscorekeeper.main.fragment



import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView

import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.main.MyViewModel
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
class MyFragmentTest {

    // Executes tasks in the Architecture Components in the same thread
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var scenario: FragmentScenario<MyFragment>

    @Before
    fun setup() {
        val myLiveData: MutableLiveData<Int> = MutableLiveData(0)

        val viewModel: MyViewModel = mock(MyViewModel::class.java)

        `when`(viewModel.scoreLiveData).thenReturn(myLiveData)

        scenario = launchFragmentInContainer(
            factory = MainFragmentFactory(viewModel),
            fragmentArgs = null,
            themeResId = R.style.Theme_TDDScoreKeeper,
            initialState = Lifecycle.State.RESUMED
        )

        scenario.apply {

        }

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
    fun `Button Plus properties`() {
        val btnPlus = onView(withId(R.id.btn_plus))

        btnPlus
            .check(ViewAssertions.matches(isDisplayed()))
            .perform(ViewActions.click())

    }

    @Test
    fun `EditText Score properties`() {
        val score = R.id.tv_score



        val tvScore = onView(withId(score))



        tvScore
            .check(ViewAssertions.matches(isDisplayed()))
           .check(ViewAssertions.matches(not(isClickable())))

//        onView(withId(score)).check(ViewAssertion.matches(withText("This is a test.")));

    }

    @Test
    fun `EditText HighScore properties`() {
        val highScore = onView(ViewMatchers.withId(R.id.tv_highScore))

        highScore
            .check(ViewAssertions.matches(isDisplayed()))
            .check(ViewAssertions.matches(not(isClickable())))
    }


}

