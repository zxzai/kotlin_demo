package com.example.app.sample

import android.util.Log

fun main() {

    //循环100次,打印0到99
    repeat(100) {
        println(it)
    }

    //打印0到99
    for (i in 0..99) {
        print(i)
    }

    println("")


    var array = arrayOf(1, 22, 33, 44, 55, 66, 7777);

    //until函数被infix关键字，原意思是 0.until(array.size)
    for (i in 0 until array.size) {
        print(array[i])
    }

    println("")

    //返回array 的下标区间array.indices
    for (i in array.indices) {
        print(array[i])
    }

    log("测试");
}

//inline 关键字会把方法内的代码复制到调用处
inline fun log(text:String){
    Log.e("test",text)
}

