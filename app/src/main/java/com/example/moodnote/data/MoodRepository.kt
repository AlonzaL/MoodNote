package com.example.moodnote.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoodRepository @Inject constructor() {
    private val _notes = MutableStateFlow<List<MoodNote>>(emptyList())
    val notes: StateFlow<List<MoodNote>> = _notes.asStateFlow()

    fun addNote(note: MoodNote) {
        _notes.value = _notes.value + note
    }

    fun deleteNote(id: Int) {
        _notes.value = _notes.value.filter { it.id != id }
    }
}