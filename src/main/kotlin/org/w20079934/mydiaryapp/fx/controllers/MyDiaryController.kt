package org.w20079934.mydiaryapp.fx.controllers

import org.w20079934.mydiaryapp.fx.models.MyDiaryModel
import org.w20079934.mydiaryapp.fx.views.MyDiaryView
import tornadofx.Controller
import java.time.LocalDate


class MyDiaryController : Controller() {

    private var diaryName = ""
    private var entries : ArrayList<MyDiaryModel> = ArrayList()

    fun getDiaryName() : String
    {
        return diaryName
    }

    fun setDiaryName(name : String)
    {
        diaryName = name
        find<MyDiaryView>().diaryWelcome.text = "Hello $diaryName"
    }

    fun updateEntryUIList()
    {
        find<MyDiaryView>().entryList.refresh()
    }

    fun handleEntry(date :LocalDate,text: String) {
        getEntry(date).entry = text
    }

    fun getEntryContent(todaysDate: LocalDate) : String {
        for (entry in entries) {
            if (entry.date == todaysDate) return entry.entry
        }
        return ""
    }

    fun getEntry(todaysDate: LocalDate) : MyDiaryModel {
        for (entry in entries) {
            if (entry.date == todaysDate) return entry
        }
        val newEntry = MyDiaryModel(todaysDate,"")
        entries.add(newEntry)
        find<MyDiaryView>().entryList.items.add(newEntry)
        return newEntry
    }

    fun getEntries() : ArrayList<MyDiaryModel>
    {
        return entries
    }

    fun removeItem(item: MyDiaryModel) {
        entries.remove(item)
        find<MyDiaryView>().entryList.items.remove(item)
        updateEntryUIList()
    }

    init {
        println("controller initialized!")
        diaryName = "World"
        entries.add(MyDiaryModel(LocalDate.of(2020,11,4),"the day before yesterday"))
        entries.add(MyDiaryModel(LocalDate.of(2020,11,5),"yesterday"))
        entries.add(MyDiaryModel(LocalDate.of(2020,11,6),"today"))
    }
}