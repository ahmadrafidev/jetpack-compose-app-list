package dev.ahmadrafi.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.ahmadrafi.movieapp.MoviewRow
import dev.ahmadrafi.movieapp.navigations.MovieScreen

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Cyan,
                elevation = 5.dp,
            ) {
                Text(text = "Movie App",
                    style = TextStyle(
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )
                )
            }
        }
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
    "Avatar", "300", "More Life", "Baby Gone", "Waves", "Harry Potter"
)){
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        LazyColumn {
            items(items = movieList) {
                MoviewRow(movie = it) {
                        movie -> navController.navigate(route = MovieScreen.DetailsScreen.name+"/$movie")
                }
            }
        }
    }
}