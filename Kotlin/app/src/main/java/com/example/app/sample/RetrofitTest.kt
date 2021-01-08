package com.example.app.sample

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET


interface API {
    @GET("lessons")
    fun lessons(): Call<Any>
}

var RETROFIT = Retrofit.Builder()
        .baseUrl("https://www.test.com/")
        .build()

//使用内联函数声明和 reified  ,可以直接使用泛型的类型，等价于下面注释的内容
//inline 和 reified 要配合使用才能定义带实化类型参数的函数基本
inline fun <reified T> create(): T {
    return RETROFIT.create(T::class.java);
}

fun main() {
    println(create<API>())
}

/*

fun <T> create(clazz: Class<T>): T {
    return RETROFIT.create(clazz);
}

fun main() {
    println(create(API::class.java))
}*/
