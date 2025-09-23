package com.example.moodnote.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moodnote.screens.AddMoodScreen
import com.example.moodnote.screens.MoodListScreen
import com.example.moodnote.viewModel.MoodViewModel

@Composable
fun MoodNotesNavGraph(
    viewModel: MoodViewModel
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "mood_list"
    ) {
        composable("mood_list") {
            MoodListScreen(
                viewModel = viewModel,
                onAddClick = { navController.navigate("add_mood") }
            )
        }

        composable("add_mood") {
            AddMoodScreen(
                viewModel = viewModel,
                onNoteAdded = { navController.popBackStack() }
            )
        }
    }
}