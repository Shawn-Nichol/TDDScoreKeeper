package com.example.tddscorekeeper.main.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.main.MyViewModel
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.LooperMode
import org.robolectric.shadows.ShadowLooper

@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
class MyFragmentTest {

    // Executes tasks in the Architecture Components in the same thread
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()



    private lateinit var scenario: FragmentScenario<MyFragment>



    @Before
    fun setup() {


    }

    @Test
    fun testOne() = runBlockingTest {
        ShadowLooper.runMainLooperToNextTask()
        val viewModel: MyViewModel = mock(MyViewModel::class.java)



        scenario = launchFragmentInContainer(
            factory = MainFragmentFactory(viewModel),
            fragmentArgs = null,
            themeResId = R.style.Theme_TDDScoreKeeper,
            initialState = Lifecycle.State.RESUMED
        )


//        scenario.moveToState(Lifecycle.State.RESUMED)

//        shadowOf(Looper.getMainLooper()).idle()
//        scenario.recreate() // Simulates if the phone ran low on resources and the app had to be recreated.

    }

    @Test
    fun testTwo() {
        val viewModel: MyViewModel = mock(MyViewModel::class.java)



        scenario = launchFragmentInContainer {
            MyFragment(viewModel).also {

                it.liveDataObserver()
            }
        }
    }
}

// FragmentScenario doesn't appear to be the problem,
// This is either a problem with robolectric or the test scope.