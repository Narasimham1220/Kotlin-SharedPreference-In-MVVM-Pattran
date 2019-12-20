package com.example.sampletask.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sampletask.R
import com.example.sampletask.utils.PreferenceProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(this,
            PreferenceProvider(this@MainActivity).get("key_timezone"),
            Toast.LENGTH_LONG
        ).show()
    }
}
