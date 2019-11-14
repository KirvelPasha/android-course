package com.example.myapplication

import android.app.IntentService
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.lang.StringBuilder

const val QUANTITY = "quantity"
const val NUMBERS = "numbers"

class MainIntentService : IntentService("MainIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        val n = intent?.getIntExtra(MESSAGE, 0)
        val numbers: ArrayList<Int> = ArrayList()
        addPrime(n!!, numbers)

        val responseIntent = Intent("main_activity")
        responseIntent.putExtra(QUANTITY, numbers.size)
        responseIntent.putExtra(NUMBERS,numbersToString(numbers).toString())
        LocalBroadcastManager.getInstance(this).sendBroadcast(responseIntent)
    }

    private fun isPrime(n: Int): Boolean {
        if (n <= 1)
            return false
        for (i in 2 until n)
            if (n % i == 0)
                return false
        return true
    }

    private fun addPrime(n: Int, numbers: ArrayList<Int>) {
        numbers.add(0)
        for (i in 2..n) {
            if (isPrime(i))
                numbers.add(i)
        }
    }

    private fun numbersToString(numbers: ArrayList<Int>): StringBuilder {
        val str: StringBuilder = StringBuilder()
        for (i in numbers) {
            str.append(i)
            if (i != numbers.last()) {
                str.append(", ")
            }
        }
        return str
    }
}
