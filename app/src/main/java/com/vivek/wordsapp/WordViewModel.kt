package com.vivek.wordsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vivek.wordsapp.model.Word
import com.vivek.wordsapp.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(private val wordRepository: WordRepository) : ViewModel() {
    fun saveWord(word: String) = liveData {
        try {
            wordRepository.insertWord(Word(0, word))
            emit(true)
        } catch (e: Exception) {
            emit(false)
        }
    }


    fun getAllWords() = wordRepository.getAllWords()
    
}