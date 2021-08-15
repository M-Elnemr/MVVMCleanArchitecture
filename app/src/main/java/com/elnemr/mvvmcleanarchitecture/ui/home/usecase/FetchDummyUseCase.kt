package com.elnemr.mvvmcleanarchitecture.ui.home.usecase

import com.elnemr.mvvmcleanarchitecture.base.NetworkResult
import com.elnemr.mvvmcleanarchitecture.base.usecase.BaseUseCase
import com.elnemr.mvvmcleanarchitecture.base.usecase.UseCase
import com.elnemr.mvvmcleanarchitecture.models.DummyModel
import com.elnemr.mvvmcleanarchitecture.ui.home.repository.HomeRepository
import javax.inject.Inject

class FetchDummyUseCase @Inject constructor(private val homeRepository: HomeRepository) :
    BaseUseCase<NetworkResult<DummyModel>, HashMap<String, String>>() {

    override suspend fun execute(params: HashMap<String, String>?) {
        liveData.value = NetworkResult.Loading()

        try{
            val response = homeRepository.fetchNetworkData(params!!)
            liveData.value = handleResponse(response)

        }catch (e: Exception){
            liveData.value = NetworkResult.Error(e.message)
        }
    }



}