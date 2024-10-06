package com.example.quizapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CardDefaults
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
fun Question(navHostController: NavHostController,vm: VM){
    var PG = remember { mutableStateOf<Float>(0.0F) }
    var indexing = remember { mutableStateOf(0) }
    var indexdata by remember { mutableStateOf(QList[indexing.value])}
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
LazyColoumnDisplay(vm,data = indexdata, progress =PG, {
    if (indexing.value< QList.size-1){
        indexing.value+=1
        indexdata= QList[indexing.value]
    }

},indexing,{navHostController.navigate(Screens.ResultScreen.route)})

    }
}
@Composable
fun LazyColoumnDisplay(vm: VM,data:QA,progress:MutableState<Float>,onSubmitClicked:()->Unit,index:MutableState<Int>,onFinalScreen:()->Unit){
    var selectedOption by remember { mutableStateOf(0) }
    var colorofSelected by remember { mutableStateOf(0) }
    var CorectAns by remember { mutableStateOf(0) }
    var Result by remember { mutableStateOf(0) }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
         Text(text = data.Question, color = Color.Black, fontWeight = FontWeight.Bold)
        Image(painter = painterResource(id =data.Image), contentDescription =null)
            LinearProgressIndicator(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(10.dp), color = Color.Green,progress=progress.value)
            Text(text ="${data.id}/${QList.size}" )
        Card(modifier = Modifier
            .height(40.dp)
            .width(300.dp)
            .clickable {
                selectedOption = 1
            }
            .border(
                if (selectedOption == 1) {
                    BorderStroke(2.dp, Color.Black)
                } else
                    BorderStroke(0.dp, Color.Transparent)
            ), colors = CardDefaults.cardColors(if (colorofSelected==1) Color.Red else if(CorectAns==1) Color.Green else Color.LightGray)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "${data.Option1}")
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        Card(modifier = Modifier
            .height(40.dp)
            .width(300.dp)
            .clickable { selectedOption = 2 }
            .border(
                if (selectedOption == 2) {
                    BorderStroke(2.dp, Color.Black)
                } else
                    BorderStroke(0.dp, Color.Transparent)
            ), colors = CardDefaults.cardColors(if (colorofSelected==2) Color.Red else if(CorectAns==2) Color.Green else Color.LightGray)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "${data.Option2}")
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        Card(modifier = Modifier
            .height(40.dp)
            .width(300.dp)
            .clickable { selectedOption = 3 }
            .border(
                if (selectedOption == 3) {
                    BorderStroke(2.dp, Color.Black)
                } else
                    BorderStroke(0.dp, Color.Transparent)
            ), colors = CardDefaults.cardColors(if (colorofSelected==3) Color.Red else if(CorectAns==3) Color.Green else Color.LightGray)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "${data.Option3}")
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        Card(modifier = Modifier
            .height(40.dp)
            .width(300.dp)
            .clickable { selectedOption = 4 }
            .border(
                if (selectedOption == 4) {
                    BorderStroke(2.dp, Color.Black)
                } else
                    BorderStroke(0.dp, Color.Transparent)
            ), colors = CardDefaults.cardColors(if (colorofSelected==4) Color.Red else if(CorectAns==4) Color.Green else Color.LightGray)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "${data.Option4}")    
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        Button(onClick = {
if(selectedOption==data.CorrectAns){
    CorectAns=data.CorrectAns
    Result+=1
}
            else {
                colorofSelected=selectedOption
    CorectAns=data.CorrectAns
            }
                         }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), shape = RectangleShape, colors = ButtonDefaults.buttonColors(Color.Blue)) {
            Text(text = "SUBMIT", color = Color.White)
        }
        if (index.value!=QList.size-1){
            Button(onClick = {
                onSubmitClicked()
                selectedOption=0
                colorofSelected=0
                CorectAns=0
                progress.value+=0.33F
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), shape = RectangleShape, colors = ButtonDefaults.buttonColors(Color.Blue)) {
                Text(text = "NextQuestion", color = Color.White)
            }
        }
        if (index.value==QList.size-1){
            Button(onClick = {
                vm.setResult(Result)
                onFinalScreen()
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), shape = RectangleShape, colors = ButtonDefaults.buttonColors(Color.Blue)) {
                Text(text = "Result Screen", color = Color.White)
            }
        }


        
    }
}