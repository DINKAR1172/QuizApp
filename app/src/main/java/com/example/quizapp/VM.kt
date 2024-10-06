package com.example.quizapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class VM:ViewModel() {
    private var _Result = mutableStateOf(0)
    var Result:State<Int> =_Result
    fun setResult(num:Int){
        _Result.value=num
    }
}