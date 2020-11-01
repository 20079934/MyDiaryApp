package org.w20079934.mydiaryapp.fx.views

import tornadofx.*

class MyDiaryView : View()
{

    override val root = pane {
        button("Press Me") {
            setOnAction {
                println("You pressed the button")
            }
        }
    }
    init {
        setWindowMinSize(640,480)
        title = "My Diary"
    }
}