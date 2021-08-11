package com.elnemr.mvvmcleanarchitecture.base.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elnemr.mvvmcleanarchitecture.base.NetworkResult
import retrofit2.Response

abstract class BaseUseCase<T, Params>(
    protected val liveData: MutableLiveData<T> = MutableLiveData()
) : UseCase<T, Params> {


    override fun getLiveData(): LiveData<T> = liveData

    fun<T> handleResponse(response: Response<T>): NetworkResult<T> {
        return when {
            response.code() == 200 && response.isSuccessful && response.body() == null -> NetworkResult.Empty()
            response.code() == 200 && response.isSuccessful -> NetworkResult.Success(response.body()!!)
            response.message().toString().contains("timeout") -> NetworkResult.Error("TimeOut")
            else -> NetworkResult.Error(response.message())
        }
    }
}
