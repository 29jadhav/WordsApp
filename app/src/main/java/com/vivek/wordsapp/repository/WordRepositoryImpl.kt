package com.vivek.wordsapp.repository

import androidx.lifecycle.LiveData
import com.vivek.wordsapp.database.WordDao
import com.vivek.wordsapp.model.Word

class WordRepositoryImpl (private val wordDao: WordDao) : WordRepository {
    override suspend fun insertWord(word: Word) {
        wordDao.insertWord(word)
    }

    override  fun getAllWords(): LiveData<List<Word>> {
        return wordDao.getAllWords()
    }
}