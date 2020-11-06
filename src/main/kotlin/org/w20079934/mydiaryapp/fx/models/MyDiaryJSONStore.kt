package org.w20079934.mydiaryapp.fx.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.w20079934.mydiaryapp.fx.helpers.exists
import org.w20079934.mydiaryapp.fx.helpers.read
import org.w20079934.mydiaryapp.fx.helpers.write
import java.time.LocalDate
import java.util.ArrayList


val JSON_FILE = "diary.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<ArrayList<MyDiaryModel>>() {}.type


class MyDiaryJSONStore : MyDiaryStore {

    var entries = mutableListOf<MyDiaryModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): List<MyDiaryModel> {
        return entries
    }

    override fun findOne(date: LocalDate): MyDiaryModel? {
        val foundEntry: MyDiaryModel? = entries.find { p -> p.date == date }
        return foundEntry
    }

    override fun create(entry: MyDiaryModel) {
        entries.add(entry)
        serialize()
    }

    override fun update(entry: MyDiaryModel) {
        val foundEntry = findOne(entry.date!!)
        if (foundEntry != null) {
            foundEntry.entry = entry.entry
        }
        serialize()
    }

    fun remove(entry: MyDiaryModel) {
        val foundEntry = findOne(entry.date!!)
        if (foundEntry != null) {
            entries.remove(foundEntry)
        }
        serialize()
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(entries, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        entries = Gson().fromJson(jsonString, listType)
    }
}