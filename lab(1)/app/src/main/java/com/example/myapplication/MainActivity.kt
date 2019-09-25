package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val MESSAGE = "com.example.myapplication"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val answer = data?.getStringExtra(MESSAGE)
            val textView = findViewById<TextView>(R.id.textView).apply {
                text = answer
            }
        }
    }

    fun sendQuestion(view : View) {
        val editText = editText.text
        val question = editText.toString()
        val intent = Intent(this,SecondActivity::class.java).apply {
            putExtra(MESSAGE,question)
        }
        startActivityForResult(intent,1)
    }
}
