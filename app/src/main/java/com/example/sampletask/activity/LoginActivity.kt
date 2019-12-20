package com.example.sampletask.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.sampletask.R
import com.example.sampletask.utils.PreferenceProvider
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        checkUserData()

        btn_login.setOnClickListener {
            if (!TextUtils.isEmpty(InputLayout_username.editText?.text.toString()) || !TextUtils.isEmpty(
                    InputLayout_pwd.editText?.text.toString()
                )
            ) {
                PreferenceProvider(this@LoginActivity).save(
                    InputLayout_username.editText?.text.toString(),
                    InputLayout_pwd.editText?.text.toString(),
                    spn_timezone.selectedItem.toString()
                )
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Please Enter valida username & password", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    private fun timeZoneSpinner() {
        val idArray = TimeZone.getAvailableIDs()
        val idAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, idArray)
        idAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spn_timezone.adapter = idAdapter;

        for (i in 0 until idAdapter.count) {
            if (idAdapter.getItem(i).equals(TimeZone.getDefault().id)) {
                spn_timezone.setSelection(i)
            }
        }
    }

    private fun checkUserData() {
        if (!TextUtils.isEmpty(PreferenceProvider(this@LoginActivity).get("key_username"))) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        } else {
            timeZoneSpinner()
        }
    }
}

