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
/*fun dp2px(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
}*/
//函数扩展，这样Float类型就有了dp2px的方法
//扩展函数是静态解析的，在编译时就已经决定
fun Float.dp2px(): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)

object Utils {
    /*fun toast(string: String?) {
        toast(string, Toast.LENGTH_SHORT)
    }*/

    //当不传duration参数时，默认值为Toast.LENGTH_SHORT，这样就不用写上的单参数函数
    @JvmOverloads //使用@JvmOverloads注解，才能再java中使用双参数的方法，否则，只能识别到单参数的方法
    fun toast(string: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
    }
}