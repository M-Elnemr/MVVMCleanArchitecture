package com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elnemr.mvvmcleanarchitecture.MainApp
import com.elnemr.mvvmcleanarchitecture.ui.home.usecase.FetchDatabaseDummyUseCase
import com.elnemr.mvvmcleanarchitecture.ui.home.usecase.FetchDummyUseCase
import com.elnemr.mvvmcleanarchitecture.ui.home.usecase.InsertDatabaseDummyUseCase
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val application: MainApp,
    private val fetchDatabaseDummyUseCase: FetchDatabaseDummyUseCase,
    private val insertDatabaseDummyUseCase: InsertDatabaseDummyUseCase,
    private val fetchDummyUseCase: FetchDummyUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModelImpl(
            application,
            fetchDatabaseDummyUseCase,
            insertDatabaseDummyUseCase,
            fetchDummyUseCase
        ) as T
    }
}