package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textView2.text = intent.getStringExtra(MESSAGE)
    }

    fun sendAnswer(view : View) {
        val editText = editText2.text
        val answer = editText.toString()
        val intent = Intent(this,MainActivity::class.java).apply {
            putExtra(MESSAGE,answer)
        }
        setResult(Activity.RESULT_OK,intent)
        finish()
    }

}
