package com.elnemr.mvvmcleanarchitecture.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(dummyEntity: DummyEntity)

    @Query("SELECT * FROM app_table")
    fun fetchData(): Flow<List<DummyEntity>>

}