package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_activity.*

class SecondActivity : AppCompatActivity() {
    private lateinit var fragment: InputFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textQuestion.text = intent.getStringExtra(MESSAGE)

        this.fragment = supportFragmentManager.findFragmentById(R.id.answer) as InputFragment
        fragment.button.setOnClickListener {
            val intent = Intent().apply {
                putExtra(MESSAGE, fragment.editText.text.toString())
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
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

    override fun finishAndRemoveTask() {
        val intent = Intent().apply {
            putExtra(FINISH, FINISH)
        }
        setResult(Activity.RESULT_OK, intent)
        super.finishAndRemoveTask()
    }
}
