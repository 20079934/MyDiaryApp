package org.w20079934.mydiaryapp.fx.views

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.control.ListView
import org.w20079934.mydiaryapp.fx.controllers.MyDiaryController
import org.w20079934.mydiaryapp.fx.models.MyDiaryModel
import tornadofx.*
import java.time.LocalDate

class MyDiaryView : View("My Diary") {

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
                    openInternalWindow<DiaryNameEditor>()
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
                button("Today's Story") {
                    setOnAction {
                        openInternalWindow<DiaryEntryEditor>() //only today
                    }
                    style {
                        fontSize = 25.px
                        fitToParentSize()
                        paddingVertical = 55
                    }
                }

                button("Read A Day") {
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
                        println("item date: ${item.date} and it's contents are: ${item.entry}")
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
        entryList.items.addAll(controller.getEntries())
        diaryWelcome.text = "Hello ${controller.getDiaryName()}"
    }
}
