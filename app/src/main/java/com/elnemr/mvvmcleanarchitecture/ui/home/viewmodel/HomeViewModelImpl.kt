package com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel

import android.app.Application
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.elnemr.mvvmcleanarchitecture.base.NetworkResult
import com.elnemr.mvvmcleanarchitecture.data.local.DummyEntity
import com.elnemr.mvvmcleanarchitecture.models.DummyModel
import com.elnemr.mvvmcleanarchitecture.ui.home.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    application: Application,
    private val homeRepository: HomeRepository
) : HomeViewModel(application) {

    private val dummyDataResponse: MutableLiveData<NetworkResult<DummyModel>> = MutableLiveData()

    override suspend fun fetchNetworkData(dummy: String) {
        viewModelScope.launch(Dispatchers.IO) {
            fetchNetworkDataSafeCall(dummy)
        }
    }
    override suspend fun fetchNetworkDataSafeCall(dummy: String) {
        dummyDataResponse.value = NetworkResult.Loading()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!hasInternetConnection()) {
                dummyDataResponse.value = NetworkResult.NoInternet()
                return
            }
        }
        try{
            val response = homeRepository.fetchNetworkData(dummy)
            dummyDataResponse.value = handleResponse(response)

        }catch (e: Exception){
            dummyDataResponse.value = NetworkResult.Error(e.message)
        }
    }

    override fun readLocalData(): LiveData<List<DummyEntity>> =
        homeRepository.fetchLocalData().asLiveData()

    override suspend fun insertIntoDatabase(dummyEntity: DummyEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            homeRepository.insertIntoDataBase(dummyEntity)
        }
    }




}