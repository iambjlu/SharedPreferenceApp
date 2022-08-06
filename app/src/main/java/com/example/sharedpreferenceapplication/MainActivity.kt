package com.example.sharedpreferenceapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val preference = PreferenceManager.getDefaultSharedPreferences(this)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val text1: EditText = findViewById(R.id.text1)
        button1.setOnClickListener {
            val editor = preference.edit()
            editor.putString("data", text1.text.toString())
            editor.apply()
            text1.setText("")
        }

        button2.setOnClickListener{
            text1.setText(preference.getString("data",""))
        }

    }
}