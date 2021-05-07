package com.example.tddscorekeeper.main.fragment.dialog

import androidx.fragment.app.testing.launchFragment
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.main.MyViewModel
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


@RunWith(AndroidJUnit4::class)
class ResetScoreDialogTest {


    private lateinit var viewModel: MyViewModel

    @Before
    fun setup() {
        viewModel = mock(MyViewModel::class.java)
        launchFragment(themeResId = R.style.Theme_TDDScoreKeeper) {
            return@launchFragment ResetScoreDialog(viewModel)
        }

    }

    @After
    fun close() {

    }

    @Test
    fun `Message`() {
        onView(withText(R.string.resetscore_dialog_message))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
    }


    @Test
    fun `Positive Button`() {
        onView(allOf(withId(android.R.id.button1), withText(R.string.confirm)))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
            .perform(ViewActions.click())

        verify(viewModel).resetScore()
    }

    @Test
    fun `Negative Button`() {
        onView(allOf(withId(android.R.id.button2), withText(R.string.cancel)))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
            .perform(ViewActions.click())
    }
}