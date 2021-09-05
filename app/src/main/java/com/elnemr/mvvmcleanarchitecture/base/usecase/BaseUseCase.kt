package com.elnemr.mvvmcleanarchitecture.base.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elnemr.mvvmcleanarchitecture.base.NetworkResult
import kotlinx.coroutines.*
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<T, Params>(
    protected val liveData: MutableLiveData<T> = MutableLiveData()
) : UseCase<T, Params> {

    private val parentJob = SupervisorJob()
    private val mainDispatcher = Dispatchers.Main
    private val backgroundDispatcher = Dispatchers.Default

    override val coroutineContext: CoroutineContext
        get() = parentJob + mainDispatcher

    operator fun invoke(
        params: Params?
    ) {
        launch {
            withContext(backgroundDispatcher) {
                execute(params)
            }
        }
    }

    protected fun <T> startAsync(block: suspend () -> T): Deferred<T> = async(parentJob) {
        block()
    }

    fun clear() {
        parentJob.cancel()
    }


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
