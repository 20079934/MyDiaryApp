package org.w20079934.mydiaryapp.fx.app

import tornadofx.*

class MyDiaryView : View()
{
    override val root = vbox {
        button("Press me");
        label("Waiting");
    }
}