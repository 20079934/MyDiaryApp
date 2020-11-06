package org.w20079934.mydiaryapp.fx.models

import java.time.LocalDate

data class MyDiaryModel (
        var date: LocalDate = LocalDate.now(),
        var entry: String = "",
) {
    override fun toString(): String = date.toString()
}