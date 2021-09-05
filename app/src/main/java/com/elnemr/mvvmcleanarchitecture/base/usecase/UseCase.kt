package com.elnemr.mvvmcleanarchitecture.base.usecase

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface UseCase<T, Params> : CoroutineScope{

    fun getLiveData(): LiveData<T>
    suspend fun execute(params: Params?)

}
