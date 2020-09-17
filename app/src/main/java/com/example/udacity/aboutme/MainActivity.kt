package com.example.udacity.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.udacity.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)

        binding.doneButton.setOnClickListener {
            setNickname(it)
        }
        /*findViewById<Button>(R.id.done_button).setOnClickListener {
            setNickName(it)
        }*/
    }
    private fun setNickname(view: View) {

        with(binding) {
            nicknameText.text = nicknameEdit.text
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
        }
        /*binding.apply {
            nicknameText.text = nicknameEdit.text
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
        }*/

        /*val nicknameEdit: EditText = findViewById(R.id.nickname_edit)
        val nicknameText: TextView = findViewById(R.id.nickname_text)

        nicknameText.text = nicknameEdit.text
        nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE*/

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}