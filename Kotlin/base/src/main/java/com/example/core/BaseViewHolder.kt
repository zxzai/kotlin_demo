package com.example.core

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * 普通类相当于final修饰，不能被继承
 *
 * abstarct 、override 、open 声明才可以被继承
 */
abstract class BaseViewHolder : RecyclerView.ViewHolder {

    constructor(itemView: View) : super(itemView) {
    }


    private val viewHashMap: MutableMap<Int, View> = HashMap()

    fun <T : View?> getView(id: Int): T? {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as T?
    }

    fun setText(id: Int, text: String?) {
        (getView<View>(id) as TextView).text = text
    }


}