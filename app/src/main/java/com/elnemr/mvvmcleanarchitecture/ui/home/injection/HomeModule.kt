package com.elnemr.mvvmcleanarchitecture.ui.home.injection

import com.elnemr.mvvmcleanarchitecture.ui.home.repository.HomeRepository
import com.elnemr.mvvmcleanarchitecture.ui.home.repository.HomeRepositoryImpl
import com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel.HomeViewModel
import com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel.HomeViewModelImpl
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
    fun provideHomeViewModel(viewModel: HomeViewModelImpl): HomeViewModel = viewModel

}