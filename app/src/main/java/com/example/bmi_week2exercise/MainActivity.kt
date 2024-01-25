package com.example.bmi_week2exercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_week2exercise.ui.theme.BMI_Week2ExerciseTheme
import java.nio.file.WatchEvent
import androidx.compose.material3.Text as Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMI_Week2ExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Bmi()
                }
            }
        }
    }
}

@Composable
fun Bmi() {
    var heightInput: String by remember { mutableStateOf(" ")}
    var weightInput: String by remember { mutableStateOf(" ")}
    var height = heightInput.toFloatOrNull() ?: 0f
    var weight = weightInput.toIntOrNull() ?:0
    var nmi = if (weight >0 && height > 0) weight/ (height * weight) else 0.0
    Column() {
        Text(
            text="Body mass index",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = heightInput,
            onValueChange ={heightInput = it.replace(oldChar=",", newChar=".")},
            label = { Text(text="Height") },
            singleLine = true,
            keyboardActions = KeyboardOptions(keyboardType = keyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = weightInput,
            onValueChange ={weightInput = it.replace(oldChar=",", newChar=".")},
            label = { Text(text="Weight") },
            singleLine = true,
            keyboardActions = KeyboardOptions(keyboardType = keyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    BMI_Week2ExerciseTheme{
        Bmi()
    }
}
