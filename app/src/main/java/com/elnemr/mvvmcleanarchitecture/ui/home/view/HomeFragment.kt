package com.elnemr.mvvmcleanarchitecture.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.elnemr.mvvmcleanarchitecture.R
import com.elnemr.mvvmcleanarchitecture.base.view.BaseFragment
import com.elnemr.mvvmcleanarchitecture.data.local.DummyEntity
import com.elnemr.mvvmcleanarchitecture.databinding.FragmentHomeBinding
import com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel.HomeViewModel
import com.elnemr.mvvmcleanarchitecture.ui.home.viewmodel.HomeViewModelFactory
import com.elnemr.mvvmcleanarchitecture.util.observe
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment(override val layoutResourceLayout: Int = R.layout.fragment_home) :
    BaseFragment<FragmentHomeBinding>() {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        insertIntoDatabase()
        readDatabase()
        return rootView
    }

    private fun readDatabase(){
        lifecycleScope.launch {
            delay(5000)
            viewModel.readLocalData()
        }
    }

    private fun insertIntoDatabase(){
        lifecycleScope.launch {
            viewModel.insertIntoDatabase(DummyEntity("Dummy"))
        }
    }

    override fun setUpViewModelStateObservers() {
        observe(viewModel.getState()) { onStateChanged(it) }
    }

    private fun onStateChanged(state: HomeViewModel.State) {
        when (state) {
            is HomeViewModel.State.DummyDataBaseLoaded -> {
                observe(state.data){
                    read(it)
                }
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

    private fun read(it: List<DummyEntity>) {
        Toast.makeText(context, it[0].name, Toast.LENGTH_SHORT).show()
    }

    override fun onFragmentCreated(dataBinder: FragmentHomeBinding) {
        dataBinder.dummy = "Hello There"
    }
}