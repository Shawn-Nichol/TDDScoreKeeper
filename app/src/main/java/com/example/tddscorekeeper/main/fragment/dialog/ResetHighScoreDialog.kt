package com.example.tddscorekeeper.main.fragment.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.main.MainViewModel
import com.google.android.material.snackbar.Snackbar
import java.lang.IllegalStateException

class ResetHighScoreDialog(val viewModel: MainViewModel) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.i("Practice", "ResetHighScoreDialog created")
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.message_reset_high_score)
                .setPositiveButton(R.string.confirm, DialogInterface.OnClickListener { dialog, it ->
                    viewModel.resetHighScore(0)
                })
                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener { dialog, it ->
                    Snackbar.make(
                        requireActivity()
                            .findViewById(R.id.scoreKeeperFragment), getString(
                            R.string.snackbar_high_score
                        ),
                        2000
                    )
                        .show()
                })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}