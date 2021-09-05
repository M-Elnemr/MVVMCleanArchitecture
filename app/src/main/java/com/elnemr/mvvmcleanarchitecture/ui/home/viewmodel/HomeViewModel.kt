package com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.elnemr.mvvmcleanarchitecture.base.NetworkResult
import com.elnemr.mvvmcleanarchitecture.base.viewModel.BaseViewModel
import com.elnemr.mvvmcleanarchitecture.data.local.DummyEntity
import com.elnemr.mvvmcleanarchitecture.models.DummyModel

abstract class HomeViewModel(application: Application) : BaseViewModel(application) {
    protected val mediator: MediatorLiveData<State> = MediatorLiveData()

    sealed class State {
        data class DummyLoaded(val data: NetworkResult<DummyModel>) : State()
        data class DummyDataBaseLoaded(val data: LiveData<List<DummyEntity>>) : State()
        data class DummyDataInserted(val isInserted: Boolean) : State()
        object ShowLoading : State()
        object ShowContent : State()
    }

    fun getState(): LiveData<State> = mediator

    abstract fun readLocalData()
    abstract fun insertIntoDatabase(dummyEntity: DummyEntity)
    abstract fun fetchNetworkData(params: HashMap<String, String>)

}