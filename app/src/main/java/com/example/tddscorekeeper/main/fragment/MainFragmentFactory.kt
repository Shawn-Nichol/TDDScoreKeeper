package com.example.tddscorekeeper.main.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.tddscorekeeper.main.MainViewModel
import com.example.tddscorekeeper.main.fragment.dialog.ResetHighScoreDialog
import com.example.tddscorekeeper.main.fragment.dialog.ResetScoreDialog

class MainFragmentFactory(private val viewModel: MainViewModel) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            ScoreKeeperFragment::class.java.name -> {
                ScoreKeeperFragment(viewModel)
            }

            ResetScoreDialog::class.java.name -> {
                ResetScoreDialog(viewModel)
            }

            ResetHighScoreDialog::class.java.name -> {
                ResetHighScoreDialog(viewModel)
            }
            else -> super.instantiate(classLoader, className)
        }
    }
}