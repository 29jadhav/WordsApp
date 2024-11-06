package com.vivek.wordsapp.di

import com.vivek.wordsapp.database.WordDao
import com.vivek.wordsapp.repository.WordRepository
import com.vivek.wordsapp.repository.WordRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object WordsModule {

    @Provides
    fun provideWordRepository(wordDao: WordDao): WordRepository{
        return WordRepositoryImpl(wordDao)
    }
}