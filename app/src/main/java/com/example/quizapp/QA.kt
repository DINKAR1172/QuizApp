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

val QList= mutableListOf(QA(1,"What Country does this Flag Belong to ?",R.drawable.flag_of_india,"India","France","UK","UAE",1),
    QA(2,"What Country does this Flag Belong to ?",R.drawable.flag_us_svgrepo_com,"IRAN","RUSSIA","USA","UKRAINE",3)
            ,QA(3,"What Country does this Flag Belong to ?",R.drawable.flag_of_sri_lanka,"pakistan","Germany","Nepal","Srilanka",4),
    QA(4,"What Country does this Flag Belong to ?",R.drawable.flag_of_russia,"Ukraine","Russia","Poland","China",2))
