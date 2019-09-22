package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val question = intent.getStringExtra(MESSAGE)
        val textView = findViewById<TextView>(R.id.textView2).apply {
            text = question
        }
    }

    fun sendAnswer(view : View) {
        val editText = findViewById<EditText>(R.id.editText2)
        val answer = editText.text.toString()
        val intent = Intent(this,MainActivity::class.java).apply {
            putExtra(MESSAGE,answer)
        }
        startActivity(intent)

    }

}