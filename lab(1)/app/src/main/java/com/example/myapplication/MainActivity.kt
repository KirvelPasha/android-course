package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
const val MESSAGE = "com.example.myapplication"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2) {
            val answer = data?.getStringExtra(MESSAGE)
            val textView = findViewById<TextView>(R.id.textView).apply {
                text = answer
            }
        }
    }

    fun sendQuestion(view : View) {
        val editText = findViewById<EditText>(R.id.editText)
        val question = editText.text.toString()
        val intent = Intent(this,SecondActivity::class.java).apply {
            putExtra(MESSAGE,question)
        }
        startActivityForResult(intent,1)
    }
}
