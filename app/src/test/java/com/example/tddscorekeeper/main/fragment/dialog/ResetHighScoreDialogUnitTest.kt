package com.example.tddscorekeeper.main.fragment.dialog

import androidx.fragment.app.testing.launchFragment
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.main.MainViewModel
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ResetHighScoreDialogUnitTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = mock(MainViewModel::class.java)

        launchFragment(themeResId = R.style.Theme_TDDScoreKeeper) {
            return@launchFragment ResetHighScoreDialog(viewModel)
        }
    }

    @Test
    fun message() {
        onView(withText(R.string.message_reset_high_score))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
    }

    @Test
    fun `Positive Button`() {
        onView(allOf(withId(android.R.id.button1), withText(R.string.confirm)))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
            .perform(ViewActions.click())

        verify(viewModel).resetHighScore(0)
    }

    @Test
    fun `Negative Button`() {
        onView(allOf(withId(android.R.id.button2), withText(R.string.cancel)))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
            .check(matches(isClickable()))

        // Click action not performed because it launches a SnackBar back in the fragment.
    }
}