package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val usernameKey = "username"
    private val passwordKey = "password"

    private lateinit var et_username: EditText
    private lateinit var et_password: EditText
    private lateinit var et_code: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)

        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))

        val btn_login = findViewById<Button>(R.id.btn_login)
        val img_code = findViewById<CodeView>(R.id.code_view)
        btn_login.setOnClickListener(this)
        img_code.setOnClickListener(this)
    }


    //传入时可以传函数，
    override fun onClick(view: View?) {
        if (view is CodeView) {
            view.updateCode()
        } else if (view is Button) {
            login()
        }
    }

    private fun login() {
        val username = et_username.text.toString()
        val password = et_password.text.toString()
        val code = et_code.text.toString()

        val user = User(username, password, code)

        //函数可内嵌函数，但没事调用都会生成一个函数对象，并不推荐
        /*fun verify(): Boolean {
            if (user.username?.length ?: 0 < 4) {
                Utils.toast("用户名不合法")
                return false
            }
            if (user.password?.length ?: 0 < 4) {
                Utils.toast("密码不合法")
                return false
            }
            return true
        }*/

        if (verify(user)) {
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey, password)
            startActivity(Intent(this, LessonActivity::class.java))
        }
    }

    private fun verify(user: User): Boolean {
//        if (user.username != null && user.username!!.length < 4) {
        //如果user.username不空，则返回对应的length,如果是空，则返回默认值0，然后在判断是否小于4
        if (user.username?.length ?: 0 < 4) {
            Utils.toast("用户名不合法")
            return false
        }

//        if (user.password != null && user.password!!.length < 4) {
        if (user.password?.length ?: 0 < 4) {
            Utils.toast("密码不合法", 1)
            return false
        }
        return true
    }
}