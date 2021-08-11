package com.elnemr.mvvmcleanarchitecture.ui.home.injection

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.elnemr.mvvmcleanarchitecture.base.NetworkResult
import com.elnemr.mvvmcleanarchitecture.base.usecase.UseCase
import com.elnemr.mvvmcleanarchitecture.data.local.DummyEntity
import com.elnemr.mvvmcleanarchitecture.models.DummyModel
import com.elnemr.mvvmcleanarchitecture.ui.MainActivity
import com.elnemr.mvvmcleanarchitecture.ui.home.repository.HomeRepository
import com.elnemr.mvvmcleanarchitecture.ui.home.repository.HomeRepositoryImpl
import com.elnemr.mvvmcleanarchitecture.ui.home.usecase.FetchDatabaseDummyUseCase
import com.elnemr.mvvmcleanarchitecture.ui.home.usecase.FetchDummyUseCase
import com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object HomeModule {

    @Provides
    @ActivityRetainedScoped
    fun provideHomeRepository(repository: HomeRepositoryImpl): HomeRepository = repository

    @Provides
    @ActivityRetainedScoped
    fun provideHomeViewModel(activity: MainActivity): HomeViewModel =
        ViewModelProvider(activity).get(HomeViewModel::class.java)

    @Provides
    @ActivityRetainedScoped
    fun provideFetchDummyUseCase(fetchDummyUseCase: FetchDummyUseCase): UseCase<NetworkResult<DummyModel>, HashMap<String, String>> =
        fetchDummyUseCase

    @Provides
    @ActivityRetainedScoped
    fun provideFetchDatabaseDummyUseCase(fetchDatabaseDummyUseCase: FetchDatabaseDummyUseCase): UseCase<LiveData<List<DummyEntity>>, HashMap<String, String>> =
        fetchDatabaseDummyUseCase

}