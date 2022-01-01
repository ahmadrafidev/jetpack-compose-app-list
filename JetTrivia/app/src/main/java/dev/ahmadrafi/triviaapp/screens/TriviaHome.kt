package dev.ahmadrafi.triviaapp.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import dev.ahmadrafi.triviaapp.components.Questions

@Composable
fun TriviaHome( viewModel: QuestionsViewModel = hiltViewModel()) = Questions(viewModel)