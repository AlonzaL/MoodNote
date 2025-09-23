package com.example.moodnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import com.example.moodnote.navigation.MoodNotesNavGraph
import com.example.moodnote.ui.theme.MoodNoteTheme
import com.example.moodnote.viewModel.MoodViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoodNoteTheme {
                Surface(
                    modifier = Modifier
                        .background(Color.White)
                ) {
                    val viewModel: MoodViewModel = hiltViewModel()
                    MoodNotesNavGraph(viewModel)
                }
            }
        }
    }
}