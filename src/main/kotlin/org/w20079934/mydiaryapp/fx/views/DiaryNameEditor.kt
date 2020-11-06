package org.w20079934.mydiaryapp.fx.views

import javafx.scene.control.TextField
import org.w20079934.mydiaryapp.fx.controllers.MyDiaryController
import tornadofx.*


class DiaryNameEditor: View("Change Diary Name...") {
    val controller: MyDiaryController by inject()
    var name: TextField by singleAssign()

    override val root = vbox {
            textfield {
                name = this

            }
            button("Submit") {
                action {
                    if (name.text != "")
                    {
                        controller.setDiaryName(name.text)
                        name.text = ""
                        close()
                    }
                }
            }
        }
    }
