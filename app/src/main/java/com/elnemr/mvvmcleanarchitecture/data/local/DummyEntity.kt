package com.elnemr.mvvmcleanarchitecture.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elnemr.mvvmcleanarchitecture.util.Constants.Companion.TABLE

@Entity(tableName = TABLE)
class DummyEntity() {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}