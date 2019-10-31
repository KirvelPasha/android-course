package com.example.myapplication

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_activity.*

class ExitDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(activity)
        dialogBuilder.setMessage("Вы точно хотите выйти?")
            .setPositiveButton("Да", DialogInterface.OnClickListener {
                    dialog, id -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                (activity as Activity).finishAndRemoveTask()
            }
            })
            .setNegativeButton("Нет", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        return dialogBuilder.create();
    }
}