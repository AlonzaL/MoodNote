package com.example.moodnote.data

data class MoodNote(
    val id: Int,
    val description: String,
    val emoji: String,
    val timeStamp: Long = System.currentTimeMillis()
)
