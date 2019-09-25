package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView


class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val question = intent.getStringExtra(MESSAGE)
            val textView = findViewById<TextView>(R.id.textView2).apply {
                text = question
            }
        }
    }


    fun sendAnswer(view : View) {
        val editText = findViewById<EditText>(R.id.editText2)
        val answer = editText.text.toString()
        val intent = Intent(this,MainActivity::class.java).apply {
            putExtra(MESSAGE,answer)
        }
        startActivityForResult(intent,2)
    }

}
