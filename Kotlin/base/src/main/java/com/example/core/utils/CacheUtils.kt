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
    private val context: Context = BaseApplication.currentApplication()

    private val SP: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String?, value: String?) {
        SP.edit().putString(key, value).apply()
    }

    fun get(key: String?): String? {
        return SP.getString(key, null)
    }

}