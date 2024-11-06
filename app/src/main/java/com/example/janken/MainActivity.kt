package com.example.janken

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Content()
//            JankenTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    PlayerView(hand = 1, modifier = Modifier.padding(innerPadding))
//                }
        }
    }
}


@Composable
fun PlayerView(hand: Int) {
//    if (hand == 0) {
//        Image(painter = painterResource(id = R.drawable.gu), contentDescription = null)
//    } else if (hand == 1) {
//        Image(painter = painterResource(id = R.drawable.choki), contentDescription = null)
//    } else if (hand == 2) {
//        Image(painter = painterResource(id = R.drawable.pa), contentDescription = null)
//    }
    when (hand) {
        0 -> Image(painterResource(id = R.drawable.gu), contentDescription = null)
        1 -> Image(painterResource(id = R.drawable.choki), contentDescription = null)
        2 -> Image(painterResource(id = R.drawable.pa), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
private fun PlayerViewPreview() {
    PlayerView(hand = 0)
}

@Composable
fun ComputerView(comHand: Int) {
    when (comHand) {
        0 -> Image(painterResource(id = R.drawable.com_gu), contentDescription = null)
        1 -> Image(painterResource(id = R.drawable.com_choki), contentDescription = null)
        2 -> Image(painterResource(id = R.drawable.com_pa), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
private fun ComputerViewPreview() {
    ComputerView(comHand = 0)
}

@Composable
fun ResultView(result: Int) {
    when (result) {
        0 -> Text("あいこ")
        1 -> Text("あなたの負け。。。")
        2 -> Text("あなたの勝ち！！！")
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultViewPreview(): Unit {
    ResultView(result = 1)
}

@Composable
fun Content() {
    var myHand by remember { mutableStateOf(-1) }
    var comHand by remember { mutableStateOf(-1) }
    var result by remember { mutableStateOf(-1) }
//    val buttle = fun(myhand: Int){
//        myhand = myhand
//        comHand = (0..2).random()
//        result = (myHand - comHand + 3) % 3
//    }

    Column {
        Text("じゃんけんアプリ")
        Row {
            Button(onClick = {
                myHand = 0
                comHand = (0..2).random()
                result = (myHand - comHand + 3) % 3
            }) {
                Text("グー")
            }
            Button(onClick = {
                myHand = 1
                comHand = (0..2).random()
                result = (myHand - comHand + 3) % 3
            }) {
                Text("チョキ")
            }
            Button(onClick = {
                myHand = 2
                comHand = (0..2).random()
                result = (myHand - comHand + 3) % 3
            }) {
                Text("パー")
            }
        }
        PlayerView(hand = myHand)
        ResultView(result = result)
        ComputerView(comHand = comHand)
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentPreview() {
    Content()
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    JankenTheme {
//        Greeting("Android")
//    }
//}