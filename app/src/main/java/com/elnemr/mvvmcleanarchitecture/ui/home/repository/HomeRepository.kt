package com.elnemr.mvvmcleanarchitecture.ui.home.repository

import com.elnemr.mvvmcleanarchitecture.data.local.DummyEntity
import com.elnemr.mvvmcleanarchitecture.models.DummyModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface HomeRepository {

    suspend fun fetchNetworkData(params: HashMap<String, String>): Response<DummyModel>

    fun fetchLocalData(): Flow<List<DummyEntity>>

    suspend fun insertIntoDataBase(dummyEntity: DummyEntity)
}