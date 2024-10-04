package com.example.quizapp

import androidx.annotation.DrawableRes

data class QA(
    val id:Int,
    val Question:String,
    @DrawableRes val Image:Int,
    val Option1:String,
    val Option2:String,
    val Option3:String,
    val Option4:String,
    val CorrectAns:Int
)

val QList= mutableListOf(QA(1,"What Country does this flag belong to?",R.drawable.ic_flag_of_australia,"Argentina","Australia","Armenia","Austria",1),
    QA(2,"What Country does this flag belong to?",R.drawable.ic_flag_of_india,"USA","ThaiLand","India","Canada",3),
    QA(3,"What Country does this flag belong to?",R.drawable.ic_flag_of_germany,"China","Palestine","Iran","Germany",4),
    QA(4,"What Country does this flag belong to?",R.drawable.ic_flag_of_new_zealand,"Russia","New Zealand","France","itly",2)
)
