package com.example.app

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val usernameKey = "username"
    private val passwordKey = "password"

    private lateinit var et_username:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username=findViewById(R.id.et_username)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}