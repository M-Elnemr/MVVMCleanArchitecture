package com.elnemr.mvvmcleanarchitecture.base.usecase

import androidx.lifecycle.LiveData

interface UseCase<T, Params> {

    fun getLiveData(): LiveData<T>
    suspend fun execute(params: Params?)

}
