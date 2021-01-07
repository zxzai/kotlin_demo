package com.example.core

import android.app.Application
import android.content.Context

/**
 * 不能使用object声明，因为需要被android framework来初始化
 *
 * 所以使用静态函数时，需使用伴生对象,
 *
 * 在java中调用需要加上Companion , 如 BaseApplication.Companion.currentApplication()
 * 如果在方法上加上  @JvmStatic ，在java中就可以像原有的静态函数那样调用  BaseApplication.currentApplication()
 *
 */
class BaseApplication : Application() {

    /**
     * 内部类的单例对象
     */
    companion object {
        private lateinit var currentApplication: Context

        //@JvmStatic
        fun currentApplication(): Context {
            return currentApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        currentApplication = this
    }

}