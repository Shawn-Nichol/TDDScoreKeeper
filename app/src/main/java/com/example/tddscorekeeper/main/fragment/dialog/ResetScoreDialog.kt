package com.example.tddscorekeeper.main.fragment.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.main.MyViewModel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


class ResetScoreDialog (val viewModel: MyViewModel) : DialogFragment() {


    lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(getString(R.string.resetscore_dialog_message))
                .setPositiveButton(getString(R.string.confirm),
                    DialogInterface.OnClickListener { dialog, id ->
                        viewModel.resetScore()
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        Snackbar.make(requireActivity().findViewById(R.id.scoreKeeperFragment), getString(
                                                    R.string.snackbar_score), 2000)
                            .show()
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }
}
