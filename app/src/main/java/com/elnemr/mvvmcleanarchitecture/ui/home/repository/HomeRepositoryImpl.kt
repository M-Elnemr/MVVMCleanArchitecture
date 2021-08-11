package com.elnemr.mvvmcleanarchitecture.ui.home.repository

import com.elnemr.mvvmcleanarchitecture.data.local.DummyEntity
import com.elnemr.mvvmcleanarchitecture.data.local.MainDao
import com.elnemr.mvvmcleanarchitecture.data.network.ApiInterface
import com.elnemr.mvvmcleanarchitecture.models.DummyModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class HomeRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface, private val dao: MainDao): HomeRepository {

    override suspend fun fetchNetworkData(params: HashMap<String, String>): Response<DummyModel> = apiInterface.getData(params)

    override fun fetchLocalData(): Flow<List<DummyEntity>> = dao.fetchData()

    override suspend fun insertIntoDataBase(dummyEntity: DummyEntity) = dao.insertData(dummyEntity)
}