package com.example.myapplication

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class ExitDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(getActivity())
        dialogBuilder.setMessage("Вы точно хотите выйти?")
            .setPositiveButton("Да", DialogInterface.OnClickListener{
                    dialog, id -> Exiter.exitApp(activity!!)
            })
            .setNegativeButton("Нет", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        return dialogBuilder.create();
    }
}