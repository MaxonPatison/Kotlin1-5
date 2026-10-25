// MainActivity.kt
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// Задание 1
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Hello(name = "Max")  // или Hello(null)
                        TextVariants()
                        CustomButton()
                        AvatarContainer()
                    }
                }
            }
        }
    }
}

@Composable
fun Hello(name: String?) {
    if (name == null){
        Text(text = "Имя не задано")
    }else{
        Text(text = "Привет, $name!")
    }
}

// Задание 2
@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=411dp,height=891dp"
)
@Composable
fun HelloPreviewPortrait() {
    Hello(name = "Portrait Mode")
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=landscape,width=891dp,height=411dp"
)
@Composable
fun HelloPreviewLandscape() {
    Hello(name = "Landscape Mode")
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFFFFF00,
    device = "spec:parent=wearos_small_round"
)
@Composable
fun HelloPreviewRound() {
    Surface(
        shape = CircleShape,
        color = Color.Yellow,
        modifier = Modifier.size(200.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Hello(name = "Round")
        }
    }
}

// Задание 3
@Composable
fun TextVariants() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // 1. Зелёный, 16.sp, курсив, по центру
        Text(
            text = stringResource(id = R.string.compose_desc),
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        // 2. Одна строка с многоточием
        Text(
            text = stringResource(id = R.string.compose_desc),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )

        // 3. Отступ 48.dp сверху, 24.sp, чёрный текст, зелёный фон, подчёркнутый
        Text(
            text = stringResource(id = R.string.compose_desc),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
                .padding(top = 48.dp),
            fontSize = 24.sp,
            color = Color.Black,
            textDecoration = TextDecoration.Underline
        )
    }
}

// Задание 4
@Composable
fun CustomButton() {
    Button(
        onClick = { /* Действие по клику */ },
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
    ) {
        Text(
            text = "Нажми меня",
            color = Color.Black,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}


// Задание 5
@Composable
fun AvatarContainer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color.Magenta),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "МИ",
                color = Color.White
            )
        }
    }
}