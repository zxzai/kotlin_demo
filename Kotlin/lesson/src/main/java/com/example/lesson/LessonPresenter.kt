package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class LessonPresenter {
    companion object {
        const val LESSON_PATH: String = "lessons"
    }

    var activity: LessonActivity? = null;


    constructor(activity: LessonActivity?) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type: Type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity!!.runOnUiThread { activity!!.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity!!.runOnUiThread { Utils.toast(message) }
            }

        })
    }

    fun showPlayback() {
        //声明可修改的集合需要用ArrayList 或 MutableList
        //arrayListOf<>()
        //mutableListOf<>()
        //listOf<>()

        val playbackLessons: MutableList<Lesson> = ArrayList();
        for (lesson in lessons) {
            if (lesson.getState() === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }
        activity!!.showResult(playbackLessons)
    }


}