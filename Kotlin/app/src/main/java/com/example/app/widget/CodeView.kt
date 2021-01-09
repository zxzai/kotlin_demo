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

    private val paint: Paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        color = getContext().getColor(R.color.colorAccent)
        strokeWidth = 6f.dp2px()
        //apply返回的是本身
    }

    /**
     * 需要返回自身话，使用apply 和 also
     * 不需要返回自身，使用let 和 run
     * 需要使用this为作用域的话，使用 apply 和 run
     * 需要使用it 为作用域的话，使用 let 和 also
     *
     */

    /*
    //let{}更适合判断是否为空然后在调用相关逻辑的使用，let返回的是最后一行的结果
    private val paint: Paint = Paint().let {
        it.isAntiAlias = true
        it.style = Paint.Style.STROKE
        it.color = getContext().getColor(R.color.colorAccent)
        it.strokeWidth = 6f.dp2px()
        return@let it //
    }*/


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