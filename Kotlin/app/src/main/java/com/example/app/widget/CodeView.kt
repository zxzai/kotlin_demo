package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.example.app.R
import com.example.core.utils.dp2px
import java.util.*


//使用@JvmOverloads注解，才能再java中使用双参数的方法，否则，只能识别到单参数的方法
class CodeView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null) : AppCompatTextView(context, attr) {

    /*
    主构造函数attr默认值为null,所以不需要再写单参数的构造函数
    constructor(context: Context) : this(context, null) {
    }
    */

    private val paint: Paint = Paint()
    private val codeList = arrayOf("kotlin",
            "android",
            "java",
            "http",
            "https",
            "okhttp",
            "retrofit",
            "tcp/ip")

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(getContext().getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)

        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.color = getContext().getColor(R.color.colorAccent)
        paint.strokeWidth = 6f.dp2px()

        updateCode()
    }


    fun updateCode() {
        val random = Random().nextInt(codeList.size)
        val code = codeList[random]
        text = code
    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint);
        super.onDraw(canvas)

    }


}