package com.example.compose_layout_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_layout_example.ui.theme.Compose_layout_exampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_exampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    ColumnExample()
//                    RowExample()
//                    BoxExample()
                    MyApp()
                }
            }
        }
    }
}
//Compose의 세 가지 기본 표준 레이아웃 요소는 Column, Row, Box입니다.

@Composable
fun ColumnExample(){
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        Text(text = "Hello")
        Text(text = "World")
    }
}

@Composable
fun RowExample(){
    Row(
        modifier = Modifier.padding(24.dp)
    ){
        Text(text = "Hello")
        Text(text = "World")
    }
}

@Composable
fun BoxExample(){
    Box( modifier = Modifier.padding(24.dp)) {

        Text(text = "Hello")
        Text(text = "World")
    }
}

@Composable
fun MyApp(
    names : List<String> = listOf("world", "compose")
){
    Column(
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        for (name in names){
            Greeting(name = name)
        }
    }

}
// 데이터가 변경되면 Compose는 새 데이터로 이러한 함수를 다시 실행하여 업데이트된 UI를 만듭니다. 이를 리컴포지션이라고 합니다.
// 데이터 감지를 위해서는 mutableStateOf 로 감지합니다
// remember{}리컴포지션을 방지하기떄문에 데이터를 유지 할 수 있다
@Composable
private fun Greeting(name: String, ) {
    var expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(extraPadding)) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            ElevatedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}