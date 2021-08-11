package com.elnemr.mvvmcleanarchitecture.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    @get:LayoutRes
    protected abstract val layoutResourceLayout: Int

    lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpViewModelStateObservers()
        setUpViewSliceActionObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(layoutResourceLayout, container, false)

        initViewSlices()

        return rootView
    }


    abstract fun setUpViewSliceActionObservers()

    abstract fun setUpViewModelStateObservers()

    abstract fun initViewSlices()
}