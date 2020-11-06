package org.w20079934.mydiaryapp.fx.views

import javafx.scene.control.TextArea
import org.w20079934.mydiaryapp.fx.controllers.MyDiaryController
import tornadofx.*
import java.time.LocalDate

class DiaryEntryEditor(date: LocalDate, editable : Boolean): View("Today's entry...") {
    val controller: MyDiaryController by inject()
    var userInput: TextArea by singleAssign()
    var todaysDate = date

    override val root = vbox {
            label {
                text = "Entry for $todaysDate"
            }
            textarea {
                userInput = this
                isEditable= editable
            }
            button("Submit") {
                action {
                    if(userInput.text!="")
                    {
                        controller.handleEntry(todaysDate, userInput.text)
                        close()
                    }
                }
            }
        }

        fun loadEditor() {
            userInput.text = controller.getEntryContent(todaysDate)
        }
    }
