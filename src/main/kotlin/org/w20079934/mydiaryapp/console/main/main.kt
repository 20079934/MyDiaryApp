package org.w20079934.mydiaryapp.console.main

import org.w20079934.mydiaryapp.fx.app.MyDiaryApp
import tornadofx.launch

var diaryName = "World"

fun main()
{
    launch<MyDiaryApp>();
    /*
    var option: Int
    do
    {
        option = menu()
        when(option)
        {
            1 -> addDiaryEntry()
            2 -> readDiaryEntry()
            3 -> updateDiaryEntry()
            4 -> deleteDiaryEntry()
            5 -> changeName()
        }
    }while (option!=0)
     */
}

fun menu() : Int
{
    println("Hello $diaryName")
    println()
    println("1 - Add a diary entry")
    println("2 - Read a previous entry")
    println("3 - Update an entry")
    println("4 - Remove an entry")
    println("5 - Change diary name")
    println("------")
    println("0 - Exit")
    println()
    print("Select an option:")
    val input : String? = readLine()!!
    return if (!input.isNullOrEmpty() && input.toIntOrNull() != null) input.toInt() else -9
}

fun addDiaryEntry()
{
    println("C")
}

fun readDiaryEntry()
{
    println("R")
}

fun updateDiaryEntry()
{
    println("U")
}

fun deleteDiaryEntry()
{
    println("D")
}

fun changeName()
{
    print("Current name is [$diaryName], what name to change it to: ")
    diaryName = readLine()!!
}

