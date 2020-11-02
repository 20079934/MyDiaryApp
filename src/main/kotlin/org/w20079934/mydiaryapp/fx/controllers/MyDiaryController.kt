package org.w20079934.mydiaryapp.fx.controllers

import tornadofx.Controller


class MyDiaryController : Controller() {

    private var diaryName = ""

    fun todaysStory()
    {
        println("Writing today's story...")
    }

    fun getDiaryName() : String
    {
        return diaryName
    }

    init {
        println("controller initialized!")
        diaryName = "World"
    }
}