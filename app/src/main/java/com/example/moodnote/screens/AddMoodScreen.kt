package com.example.moodnote.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moodnote.viewModel.MoodViewModel

@Composable
fun AddMoodScreen(
    viewModel: MoodViewModel,
    onNoteAdded: () -> Unit
) {
    var text by remember { mutableStateOf("") }
    var selectEmoji by remember { mutableStateOf("😊") }

    val emojis = listOf("😊", "😢", "😡", "😴")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Добавить заметку настроения",
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text(
                    text = "Опишите своё настроение"
                )
            }
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            emojis.forEach { emoji ->
                Button(
                    onClick = { selectEmoji = emoji },
                    modifier = Modifier
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                            if (selectEmoji == emoji)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.surface
                    )
                ) {
                    Text(
                        text = emoji,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }
        Button(
            onClick = {
                if (text.isNotBlank()) {
                    viewModel.addNote(text, selectEmoji)
                    onNoteAdded()
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            enabled = text.isNotBlank()
        ) {
            Text(
                text = "Сохранить"
            )
        }
    }
}