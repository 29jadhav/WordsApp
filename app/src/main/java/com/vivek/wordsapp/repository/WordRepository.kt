package com.vivek.wordsapp.repository

import androidx.lifecycle.LiveData
import com.vivek.wordsapp.model.Word

interface WordRepository {
    suspend fun insertWord(word: Word)
    fun getAllWords(): LiveData<List<Word>>
}