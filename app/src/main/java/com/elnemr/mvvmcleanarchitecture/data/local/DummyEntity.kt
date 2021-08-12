package com.elnemr.mvvmcleanarchitecture.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elnemr.mvvmcleanarchitecture.util.Constants.Companion.TABLE

@Entity(tableName = TABLE)
data class DummyEntity(
    var name: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}