package org.w20079934.mydiaryapp.fx.controllers

import org.w20079934.mydiaryapp.fx.models.MyDiaryJSONStore
import org.w20079934.mydiaryapp.fx.models.MyDiaryModel
import org.w20079934.mydiaryapp.fx.views.MyDiaryView
import tornadofx.Controller
import java.time.LocalDate


class MyDiaryController : Controller() {

    private var diaryName : String = "World"
    private var entries = MyDiaryJSONStore()

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
        val receivedEntry = getEntry(date)
        receivedEntry.entry = text
        entries.update(receivedEntry)
    }

    fun getEntryContent(todaysDate: LocalDate) : String {
        for (entry in entries.findAll()) {
            if (entry.date == todaysDate) return entry.entry
        }
        return "Dear $diaryName,\n"
    }

    fun getEntry(todaysDate: LocalDate) : MyDiaryModel {
        for (entry in entries.findAll()) {
            if (entry.date == todaysDate) return entry
        }
        val newEntry = MyDiaryModel(todaysDate,"Dear $diaryName,\n")
        entries.create(newEntry)
        find<MyDiaryView>().entryList.items.add(newEntry)
        return newEntry
    }

    fun getEntries() : List<MyDiaryModel>
    {
        return entries.findAll()
    }

    fun removeItem(item: MyDiaryModel) {
        entries.remove(item)
        find<MyDiaryView>().entryList.items.remove(item)
        updateEntryUIList()
    }

    init {
        println("controller initialized!")
    }
}