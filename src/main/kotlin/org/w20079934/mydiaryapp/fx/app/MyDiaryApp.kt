package org.w20079934.mydiaryapp.fx.app

import org.w20079934.mydiaryapp.fx.views.MyDiaryView
import tornadofx.*

class MyDiaryApp: App(MyDiaryView::class)
{
    override fun init() {
        println("initializing the app")
    }
}