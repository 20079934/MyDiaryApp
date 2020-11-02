package org.w20079934.mydiaryapp.fx.views

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.control.ListView
import org.w20079934.mydiaryapp.fx.controllers.MyDiaryController
import org.w20079934.mydiaryapp.fx.models.MyDiaryModel
import tornadofx.*

class MyDiaryView : View("Help me") {

    val controller: MyDiaryController by inject()

    var diaryWelcome: Label by singleAssign()
    var entryList: ListView<MyDiaryModel> by singleAssign()

    override val root = vbox {
        setMinSize(640.0, 480.0)
        setMaxSize(640.0, 480.0)

        hbox() {
            label("Hello x") {
                diaryWelcome = this
                onLeftClick {
                    diaryWelcome.text = "Hello Mia"
                }
                style {
                    fontSize = 32.px
                }
            }
            style {
                alignment = Pos.CENTER
                paddingVertical = 20
            }
        }

        hbox {
            vbox {
                button("Today's Entry") {
                    setOnAction {
                        controller.todaysStory()//this one will automate to today's date, but it's similar to the previous button
                    }
                    style {
                        fontSize = 25.px
                        fitToParentSize()
                        paddingVertical = 55
                    }
                }

                button("Submit A Day") {
                    setOnAction {
                        controller.todaysStory()
                    }
                    style {
                        fontSize = 25.px
                        fitToParentSize()
                        paddingVertical = 55
                    }
                }

                button("Update") {
                    setOnAction {
                        println("Trying to update")
                    }
                    style {
                        fontSize = 25.px
                        fitToParentSize()
                        paddingVertical = 55
                    }
                }

                button("Remove") {
                    setOnAction {
                        val item = entryList.focusModel.focusedItem
                        println("item id: ${item.id} and it's contents are: ${item.entry}")
                    }
                    style {
                        fontSize = 25.px
                        fitToParentSize()
                        paddingVertical = 55
                    }
                }
                style {
                    fitToParentSize()
                }
            }
            vbox {
                listview<MyDiaryModel> {
                    entryList = this
                    style {
                    }
                }
                style {
                    fitToParentSize()
                }
            }
        }
    }

    init {
        setWindowMinSize(640, 480)
        setWindowMaxSize(640, 480)
        for (i in 0..10)
        {
            entryList.items.add(MyDiaryModel(Integer.toUnsignedLong(i),"aaa$i","a"))
        }
        diaryWelcome.text = "Hello ${controller.getDiaryName()}"
    }
}
