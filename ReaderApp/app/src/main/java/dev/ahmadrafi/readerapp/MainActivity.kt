package dev.ahmadrafi.readerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import dev.ahmadrafi.readerapp.navigation.ReaderNavigation
import dev.ahmadrafi.readerapp.ui.theme.ReaderAppTheme

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReaderAppTheme {
                ReaderApp()
            }
        }
    }
}


@ExperimentalComposeUiApi
@Composable
fun ReaderApp(){
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize(), content = {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            ReaderNavigation()
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ReaderAppTheme() {
    }
}