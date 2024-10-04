package com.example.quizapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.ui.theme.QuizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.fillMaxSize()){
                    Image(painter = painterResource(id = R.drawable.iii), contentDescription =null, modifier = Modifier.fillMaxSize() )
Navigation()
                }
        }
    }
}
@Composable
fun Navigation(navHostController: NavHostController= rememberNavController()){
    val context= LocalContext.current
    NavHost(navController = navHostController, startDestination =Screens.first.route){
        composable(Screens.first.route){
            Helloji(navHostController,context)
        }
        composable(Screens.Second.route){
            Question(navHostController)
        }
        composable(Screens.ResultScreen.route){
            com.example.quizapp.Result()
        }
    }
}
@Composable
fun Helloji(navHostController: NavHostController,context:Context){
    var name by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
       Text(text = "Quiz App!", fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold, color = Color.White, fontSize = 40.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(250.dp)
            .background(Color.White)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){
                Text(
                    text = "Welcome", fontWeight = FontWeight.Bold, fontSize = 50.sp, color = Color.Black
                )

                Text(text = "Please enter your name", color = Color.Gray)
                OutlinedTextField(value = name, onValueChange ={name=it}, placeholder = { Text(text = "eg John")}, modifier = Modifier.wrapContentSize())
                Button(
                    onClick = {if (name!=""){
                        navHostController.navigate(Screens.Second.route)
                    }
                        else{
                            Toast.makeText(context,"Enter a Name",Toast.LENGTH_LONG).show()
                        }
                        }, colors = ButtonDefaults.buttonColors(Color.Blue), modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp), shape = RectangleShape) {
                    Text(text = "START", color = Color.White)
                }
            }

        }
    }
}

