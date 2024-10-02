package com.example.quizapp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Question(navHostController: NavHostController){
    var PG = remember { mutableStateOf<Float>(0.0F) }
    var indexing = remember { mutableStateOf(0) }
    var indexdata by remember { mutableStateOf(QList[indexing.value])}
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
LazyColoumnDisplay(data = indexdata, progress =PG , Indexing =indexing )

    }
}
@Composable
fun LazyColoumnDisplay(data:QA,progress:MutableState<Float>,Indexing:MutableState<Int>){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
         Text(text = data.Question, color = Color.Black, fontWeight = FontWeight.Bold)
        Image(painter = painterResource(id =data.Image), contentDescription =null)
        Row {
            LinearProgressIndicator(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(10.dp), color = Color.Green)
            Text(text ="${Indexing.value++}/4" )
        }
        Card(modifier = Modifier
            .height(40.dp)
            .width(300.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "${data.Option1}")
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        Card(modifier = Modifier
            .height(40.dp)
            .width(300.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "${data.Option2}")
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        Card(modifier = Modifier
            .height(40.dp)
            .width(300.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "${data.Option3}")
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        Card(modifier = Modifier
            .height(40.dp)
            .width(300.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "${data.Option4}")    
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), shape = RectangleShape, colors = ButtonDefaults.buttonColors(Color.Blue)) {
            Text(text = "SUBMIT", color = Color.White)
        }
        
    }
}