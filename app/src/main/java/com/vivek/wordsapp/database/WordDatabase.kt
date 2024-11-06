package com.vivek.wordsapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vivek.wordsapp.model.Word

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordDatabase: RoomDatabase() {

    abstract  fun wordDao(): WordDao
}