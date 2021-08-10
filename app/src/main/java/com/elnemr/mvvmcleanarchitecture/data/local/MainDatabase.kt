package com.elnemr.mvvmcleanarchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DummyEntity::class], version = 1)
abstract class MainDatabase: RoomDatabase() {

    abstract fun mainDao(): MainDao
}