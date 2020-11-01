package org.w20079934.mydiaryapp.fx.models

interface MyDiaryStore {
    fun findAll(): List<MyDiaryModel>
    fun findOne(id: Long): MyDiaryModel?
    fun create(entry: MyDiaryModel)
    fun update(entry: MyDiaryModel)
}