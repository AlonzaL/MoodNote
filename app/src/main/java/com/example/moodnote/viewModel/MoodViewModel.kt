package com.example.moodnote.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodnote.data.MoodNote
import com.example.moodnote.data.MoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoodViewModel @Inject constructor(private val repository: MoodRepository) : ViewModel() {
    // хранит текущее состояние и уведомляет "подписчиков" об изменениях
    val notes: StateFlow<List<MoodNote>> = repository.notes

    fun addNote(text: String, emoji: String) {
        viewModelScope.launch {
            val newId = (notes.value.maxOfOrNull { it.id } ?: 0) + 1

            repository.addNote(MoodNote(newId, text,emoji))
        }
    }

    fun deleteNote(id: Int) {
        viewModelScope.launch {
            repository.deleteNote(id)
        }
    }
}