package com.elnemr.mvvmcleanarchitecture.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elnemr.mvvmcleanarchitecture.R
import com.elnemr.mvvmcleanarchitecture.base.view.BaseFragment

class HomeFragment(override val layoutResourceLayout: Int = R.layout.fragment_home) : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    }

    override fun initViewSlices() {
    }

}