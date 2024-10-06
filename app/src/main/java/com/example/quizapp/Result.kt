package com.example.quizapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Result(vm: VM){
    Column {
        Text(text = "Result Screen")
        Text(text = "Result Score :${vm.Result.value}")
    }
}