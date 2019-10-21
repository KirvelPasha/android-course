package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_activity.*

class FragmentActivity : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_activity, container, false)
        val button: Button = view.findViewById(R.id.button)
        button.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        val intent = Intent(getActivity(),SecondActivity::class.java).apply {
            putExtra(MESSAGE,editText.text.toString())
        }
        startActivityForResult(intent,1)
    }


}