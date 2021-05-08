package com.example.tddscorekeeper.main.fragment.dialog

import androidx.fragment.app.testing.launchFragment
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.main.MyViewModel
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class ResetScoreDialogUnitTest {


    private lateinit var viewModel: MyViewModel

    @Before
    fun setup() {
        viewModel = mock(MyViewModel::class.java)
        launchFragment(themeResId = R.style.Theme_TDDScoreKeeper) {
            return@launchFragment ResetScoreDialog(viewModel)
        }
    }

    @Test
    fun `Message`() {
        onView(withText(R.string.message_reset_score))
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
            .check(matches(isClickable()))

        // Click action not performed because it launches a snackbar that is launched in different fragment.
    }
}