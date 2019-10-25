package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Exiter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
    }

    companion object {
        fun exitApp(caller: Context) {
            val intent = Intent(caller, Exiter::class.java)
            caller.startActivity(intent)
        }
    }
}