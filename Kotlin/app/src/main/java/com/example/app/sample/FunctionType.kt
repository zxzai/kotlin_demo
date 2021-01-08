package com.example.app.sample

class View {
    //不用像java那些需要包装一个接口对象，kotlin直接传函数
    //参数传入为函数类型,分两部分，输入、输出，输入（接收的参数类型）为View ,输出（返回值）为void
    fun setOnClickListener(listener: (View) -> Unit) {
    }
}

fun main() {
    val view = View()

    //使用双冒号修饰，传递函数
    view.setOnClickListener(::onclick)

    //传递匿名函数
    view.setOnClickListener(fun(view: View) {
        print("被点击了")
    })

    //使用lamda表达式
    view.setOnClickListener {
        print("被点击了")
    }

    //以上三者效果一样
}

fun onclick(view: View) {
    print("被点击了")
}

