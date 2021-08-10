package com.elnemr.mvvmcleanarchitecture.di

import android.content.Context
import androidx.room.Room
import com.elnemr.mvvmcleanarchitecture.data.local.MainDatabase
import com.elnemr.mvvmcleanarchitecture.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): MainDatabase =
        Room.databaseBuilder(context, MainDatabase::class.java, Constants.DATABASE).build()

    @Provides
    @Singleton
    fun provideDao(mainDatabase: MainDatabase) =
        mainDatabase.mainDao()
}