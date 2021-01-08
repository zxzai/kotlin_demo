package com.example.app.sample


/**
 * 内联函数传递的参数为函数类型
 *
 * 如果不使用内联函数，那么当参数是函数类型时，调用时就会创建对应的对象，反编译可看到
 */
inline fun measureTime(action: () -> Unit) {
    println(">>>>>> ")
    val start = System.currentTimeMillis()
    action()
    val end = System.currentTimeMillis()
    println("<<<<<<<<< " + (start - end))
}

fun main() {
    //调用内联函数会把内联函数的内容都复制到此处
    //
    measureTime {
        println("打印内容")
    }
}