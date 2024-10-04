package com.example.quizapp

sealed class Screens(val route:String) {
    object first:Screens("first")
    object Second:Screens("Second")
    object ResultScreen:Screens("ResultScreen")
}