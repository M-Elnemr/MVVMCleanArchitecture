package com.elnemr.mvvmcleanarchitecture.ui.home.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.elnemr.mvvmcleanarchitecture.base.NetworkResult
import com.elnemr.mvvmcleanarchitecture.base.usecase.BaseUseCase
import com.elnemr.mvvmcleanarchitecture.base.usecase.UseCase
import com.elnemr.mvvmcleanarchitecture.data.local.DummyEntity
import com.elnemr.mvvmcleanarchitecture.models.DummyModel
import com.elnemr.mvvmcleanarchitecture.ui.home.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class InsertDatabaseDummyUseCase @Inject constructor(private val homeRepository: HomeRepository) :
    BaseUseCase<Boolean, DummyEntity>() {

    override suspend fun execute(params: DummyEntity?) = coroutineScope{
       homeRepository.insertIntoDataBase(params!!)
    }

}