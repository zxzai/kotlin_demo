//@file:JvmName("KotlinUtil") 声明java中调用顶层函数时，使用的类名 KotlinUtil.dp2px(
package com.example.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

private val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics

/**
 * 顶层函数，不用写类名.  直接写dp2px调用
 *
 * 但在java中调用，类名需要加上Kt, UtilsKt.dp2px()
 */
fun dp2px(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
}

object Utils{
    fun toast(string: String?){
        toast(string,Toast.LENGTH_SHORT)
    }

    fun toast(string: String?,duration:Int){
        Toast.makeText(BaseApplication.currentApplication(),string,duration).show()
    }
}