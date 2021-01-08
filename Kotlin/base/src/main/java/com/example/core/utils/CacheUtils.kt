package com.example.core.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.core.BaseApplication
import com.example.core.R

/**
 * object修饰，所有的函数和成员属性都是静态的，调用时需要带上类名
 *
 * 在java中调用的话，需要加上INSTANCE，  CacheUtils.INSTANCE.get(
 *
 */
object CacheUtils {
    private val context: Context = BaseApplication.currentApplication

    private val SP: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String?, value: String?) = SP.edit().putString(key, value).apply()

    /*fun save(key: String?, value: String?) {
        SP.edit().putString(key, value).apply()
    }*/

    //等价于下面get方法，方法内容只有一行时，可以直接用等号拼接
    //然后应为类型推断，再省略:String?
    //在末尾增加!!，就可以声明返回值为不可空类型
    fun get(key: String?) = SP.getString(key, null)

    /*
    fun get(key: String?): String? {
        return SP.getString(key, null)
    }*/

}