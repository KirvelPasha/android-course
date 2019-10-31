package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_activity.*

const val MESSAGE = "com.example.myapplication"
const val FINISH = "finish"
const val DIALOG = "dialog"

class MainActivity : AppCompatActivity() {
    private lateinit var fragment: InputFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.fragment = supportFragmentManager.findFragmentById(R.id.question) as InputFragment
        fragment.button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(MESSAGE, fragment.editText.text.toString())
            }
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                if (data?.getStringExtra(FINISH).equals(FINISH)) {
                    finish()
                }
                textAnswer.text = data?.getStringExtra(MESSAGE)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.close -> {
                val exitDialog = ExitDialog()
                exitDialog.show(supportFragmentManager, DIALOG)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
