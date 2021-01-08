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
        @JvmStatic
        @get:JvmName("currentApplication")//在java可以直接调用BaseApplication.currentApplication
        lateinit var currentApplication: Context
            private set //设置不能set,只能get ，这样就可以直接引用，不用再定义下面的方法

        //@JvmStatic
        // 加上@JvmStatic注解 ,在java中就不用通过BaseApplication.Companion.currentApplication(),
        // 可以直接调用BaseApplication.Companion.currentApplication()
        /*fun currentApplication(): Context {
            return currentApplication
        }*/
    }

    override fun onCreate() {
        super.onCreate()
        currentApplication = this
    }

}