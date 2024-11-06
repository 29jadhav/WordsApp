package com.vivek.wordsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideWordsDatabase(@ApplicationContext context: Context): WordDatabase{
        return Room.databaseBuilder(context, WordDatabase::class.java,"words.db").build()
    }

    @Provides
    fun wordDao(wordDatabase: WordDatabase): WordDao{
        return wordDatabase.wordDao()
    }
}