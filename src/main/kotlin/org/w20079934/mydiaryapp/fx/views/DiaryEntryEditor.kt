package org.w20079934.mydiaryapp.fx.views

import javafx.scene.control.DatePicker
import javafx.scene.control.TextArea
import org.w20079934.mydiaryapp.fx.controllers.MyDiaryController
import tornadofx.*
import java.time.Instant
import java.time.LocalDate
import java.util.*

class DiaryEntryEditor: View("Today's entry...") {
    val controller: MyDiaryController by inject()
    var userInput: TextArea by singleAssign()
    val todaysDate = LocalDate.now()

    override val root = vbox {
            label {
                text = "Entry for $todaysDate"
            }
            textarea {
            userInput = this
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

        override fun onDock() {
            userInput.text = controller.getEntryContent(todaysDate)
        }
    }
