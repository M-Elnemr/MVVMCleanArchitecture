package com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.elnemr.mvvmcleanarchitecture.base.viewModel.BaseViewModel
import com.elnemr.mvvmcleanarchitecture.data.local.DummyEntity

abstract class HomeViewModel(application: Application) : BaseViewModel(application) {

    abstract fun readLocalData(): LiveData<List<DummyEntity>>
    abstract suspend fun insertIntoDatabase(dummyEntity: DummyEntity)

    abstract suspend fun fetchNetworkData(dummy: String)
    abstract suspend fun fetchNetworkDataSafeCall(dummy: String)

}