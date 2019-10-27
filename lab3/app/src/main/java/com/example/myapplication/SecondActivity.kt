package com.example.myapplication

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
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
            val intent = Intent(this,MainActivity::class.java).apply {
                putExtra(MESSAGE,fragment.editText.text.toString())
            }
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.close -> {
                val exitDialog = ExitDialog()
                exitDialog.show(supportFragmentManager,"dialog")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
