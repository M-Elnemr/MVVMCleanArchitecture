package com.elnemr.mvvmcleanarchitecture.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.elnemr.mvvmcleanarchitecture.R
import com.elnemr.mvvmcleanarchitecture.base.view.BaseFragment
import com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment(override val layoutResourceLayout: Int = R.layout.fragment_home) :
    BaseFragment() {
        lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment

        return rootView
    }

    override fun setUpViewSliceActionObservers() {
    }

    override fun setUpViewModelStateObservers() {
//        observe(viewModel.getState()) { onStateChanged(it) }
    }

    private fun onStateChanged(state: HomeViewModel.State) {
        when (state) {
            is HomeViewModel.State.DummyDataBaseLoaded -> {
            }
            is HomeViewModel.State.DummyDataInserted -> {
            }
            is HomeViewModel.State.DummyLoaded -> {
            }
            HomeViewModel.State.ShowContent -> {
            }
            HomeViewModel.State.ShowLoading -> {
            }
        }
    }


    override fun initViewSlices() {
    }

}