package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

const val MESSAGE = "com.example.myapplication"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val answer = intent.getStringExtra(MESSAGE)
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = answer
        }
    }

    fun sendQuestion(view : View) {
        val editText = findViewById<EditText>(R.id.editText)
        val question = editText.text.toString()
        val intent = Intent(this,SecondActivity::class.java).apply {
            putExtra(MESSAGE,question)
        }
        startActivity(intent)
    }
}
