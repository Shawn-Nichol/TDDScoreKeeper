package com.example.tddscorekeeper.main.fragment.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.main.MainViewModel
import com.google.android.material.snackbar.Snackbar


class ResetScoreDialog(val viewModel: MainViewModel) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(getString(R.string.message_reset_score))
                .setPositiveButton(R.string.confirm
                ) { _, _ ->
                    viewModel.resetScore()
                }
                .setNegativeButton(R.string.cancel
                ) { _, _ ->
                    Snackbar.make(
                        requireActivity()
                            .findViewById(R.id.scoreKeeperFragment),
                        getString(
                            R.string.snackbar_score
                        ),
                        2000
                    )
                        .show()
                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }
}
