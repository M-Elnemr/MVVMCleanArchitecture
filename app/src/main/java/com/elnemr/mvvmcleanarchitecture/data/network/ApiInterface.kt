package com.elnemr.mvvmcleanarchitecture.data.network

import com.elnemr.mvvmcleanarchitecture.models.DummyModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiInterface {
    @GET("")
    suspend fun getData(
        @QueryMap params: Map<String, String>
    ): Response<DummyModel>
}