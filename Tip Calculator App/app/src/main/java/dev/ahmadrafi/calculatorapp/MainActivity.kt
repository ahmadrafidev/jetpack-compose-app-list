package dev.ahmadrafi.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ahmadrafi.calculatorapp.components.InputField
import dev.ahmadrafi.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                TopHeader()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    CalculatorAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}


@Preview
@Composable
fun TopHeader(totalPerPerson: Double = 100.0){
    Surface(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))),
        color = Color(0xFF0B6CE2)
    ){
        Column(
            modifier = Modifier
                .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Total per Person",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )
            val total = "%.2f".format(totalPerPerson)
            Text(
                text = "$$total",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
        }
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun MainContent(){
    val totalBill = remember {
        mutableStateOf("0")
    }
    val validState = remember(totalBill.value) {
        totalBill.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ){
        Column() {
            InputField(
                valueState = totalBill,
                labelId = "Amount of Bill",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if(!validState){
                        return@KeyboardActions
                        keyboardController?.hide()
                    }
                }
            )
        }
    }
}