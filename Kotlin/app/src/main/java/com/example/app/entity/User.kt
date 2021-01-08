package com.example.app.entity

/**
 * data 声明为数据类，自动生成，copy(),equals(),hashCode(),
 */
data class User constructor(var username: String?, var password: String?, var code: String?) {

    constructor() : this(null, null, null) {

    }
}