package org.w20079934.mydiaryapp.fx.app

import javafx.scene.Scene
import javafx.stage.Stage
import org.w20079934.mydiaryapp.fx.views.MyDiaryView
import tornadofx.*
import kotlin.reflect.KClass

class MyDiaryApp: App(MyDiaryView::class)
{
    override fun init() {
        println("initializing the app")
    }
}