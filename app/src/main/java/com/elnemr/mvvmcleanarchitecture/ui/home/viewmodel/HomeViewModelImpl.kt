package com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel

import android.app.Application
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.elnemr.mvvmcleanarchitecture.base.NetworkResult
import com.elnemr.mvvmcleanarchitecture.data.local.DummyEntity
import com.elnemr.mvvmcleanarchitecture.models.DummyModel
import com.elnemr.mvvmcleanarchitecture.ui.home.repository.HomeRepository
import com.elnemr.mvvmcleanarchitecture.ui.home.usecase.FetchDatabaseDummyUseCase
import com.elnemr.mvvmcleanarchitecture.ui.home.usecase.FetchDummyUseCase
import com.elnemr.mvvmcleanarchitecture.ui.home.usecase.InsertDatabaseDummyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModelImpl(
    application: Application,
    private val fetchDatabaseDummyUseCase: FetchDatabaseDummyUseCase,
    private val insertDatabaseDummyUseCase: InsertDatabaseDummyUseCase,
    private val fetchDummyUseCase: FetchDummyUseCase
) : HomeViewModel(application) {

    init {
        mediator.addSource(fetchDatabaseDummyUseCase.getLiveData(), ::onFetchDatabaseDummy)
        mediator.addSource(insertDatabaseDummyUseCase.getLiveData(), ::onInsertDatabaseDummy)
        mediator.addSource(fetchDummyUseCase.getLiveData(), ::onFetchDummy)
    }

    private fun onFetchDummy(data: NetworkResult<DummyModel>) {
        mediator.value = State.ShowContent
        mediator.value = State.DummyLoaded(data)
    }

    private fun onInsertDatabaseDummy(isInserted: Boolean) {
        mediator.value = State.ShowContent
        mediator.value = State.DummyDataInserted(isInserted)
    }

    private fun onFetchDatabaseDummy(data: LiveData<List<DummyEntity>>) {
        mediator.value = State.ShowContent
        mediator.value = State.DummyDataBaseLoaded(data)
    }

    override suspend fun fetchNetworkData(params: HashMap<String, String>) {
        mediator.value = State.ShowLoading
        viewModelScope.launch(Dispatchers.IO) {
            fetchNetworkDataSafeCall(params)
        }
    }
    private suspend fun fetchNetworkDataSafeCall(params: HashMap<String, String>) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (!hasInternetConnection()) {
//                return
//            }
//        }
        fetchDummyUseCase.execute(params)
    }

    override suspend fun readLocalData() {
        fetchDatabaseDummyUseCase.execute(null)
    }

    override suspend fun insertIntoDatabase(dummyEntity: DummyEntity) {
        insertDatabaseDummyUseCase.execute(dummyEntity)
    }

}












//
//@HiltViewModel
//class HomeViewModelImpl @Inject constructor(
//    application: Application,
//    private val homeRepository: HomeRepository
//) : HomeViewModel(application) {
//
//    private val dummyDataResponse: MutableLiveData<NetworkResult<DummyModel>> = MutableLiveData()
//
//    override suspend fun fetchNetworkData(dummy: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            fetchNetworkDataSafeCall(dummy)
//        }
//    }
//    override suspend fun fetchNetworkDataSafeCall(dummy: String) {
//        dummyDataResponse.value = NetworkResult.Loading()
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (!hasInternetConnection()) {
//                dummyDataResponse.value = NetworkResult.NoInternet()
//                return
//            }
//        }
//        try{
//            val response = homeRepository.fetchNetworkData(dummy)
//            dummyDataResponse.value = handleResponse(response)
//
//        }catch (e: Exception){
//            dummyDataResponse.value = NetworkResult.Error(e.message)
//        }
//    }
//
//    override fun readLocalData(): LiveData<List<DummyEntity>> =
//        homeRepository.fetchLocalData().asLiveData()
//
//    override suspend fun insertIntoDatabase(dummyEntity: DummyEntity) {
//        viewModelScope.launch(Dispatchers.IO) {
//            homeRepository.insertIntoDataBase(dummyEntity)
//        }
//    }
//
//}