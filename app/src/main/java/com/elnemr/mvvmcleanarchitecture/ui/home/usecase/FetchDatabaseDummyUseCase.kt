package com.elnemr.mvvmcleanarchitecture.ui.home.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.elnemr.mvvmcleanarchitecture.base.usecase.BaseUseCase
import com.elnemr.mvvmcleanarchitecture.base.usecase.UseCase
import com.elnemr.mvvmcleanarchitecture.data.local.DummyEntity
import com.elnemr.mvvmcleanarchitecture.ui.home.repository.HomeRepository
import javax.inject.Inject

class FetchDatabaseDummyUseCase @Inject constructor(private val homeRepository: HomeRepository) :
    BaseUseCase<LiveData<List<DummyEntity>>, HashMap<String, String>>() {

    override suspend fun execute(params: HashMap<String, String>?) {
        liveData.value = homeRepository.fetchLocalData().asLiveData()
    }

}