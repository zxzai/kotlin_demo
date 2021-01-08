package com.example.lesson.entity

/**
 * internal 关键字，声明只能在当前模块下访问（module）
 *
 * 在构造器中加上 var 关键字，才能变为成员属性
 */
internal class Lesson constructor(var date: String?, var content: String?, var state: State?) {
    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String?
    }
}