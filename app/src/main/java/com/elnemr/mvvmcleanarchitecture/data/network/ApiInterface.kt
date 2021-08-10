package com.elnemr.mvvmcleanarchitecture.data.network

import com.elnemr.mvvmcleanarchitecture.models.DummyModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("")
    suspend fun getData(
        dummy: String
    ): Response<DummyModel>
}