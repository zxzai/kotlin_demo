package com.example.app.sample

import com.example.core.utils.CacheUtils
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BySample {
    //委托
    var token: String by Saver("token")
    var token2: String by Saver("token")

    //通过by关键字，将token 的 getter和setter操作委托给 Saver

    class Saver(var token:String) : ReadWriteProperty<BySample, String> {
        override operator fun setValue(thisRef: BySample, property: KProperty<*>, value: String) {
            CacheUtils.save(token, value)
        }

        override operator fun getValue(thisRef: BySample, property: KProperty<*>): String {
            return CacheUtils.get(token)!!
        }
    }

}

