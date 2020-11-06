package org.w20079934.mydiaryapp.fx.models

import java.time.LocalDate

interface MyDiaryStore {
    fun findAll(): List<MyDiaryModel>
    fun findOne(date: LocalDate): MyDiaryModel?
    fun create(entry: MyDiaryModel)
    fun update(entry: MyDiaryModel)
}