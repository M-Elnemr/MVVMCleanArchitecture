package com.elnemr.mvvmcleanarchitecture.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import java.util.zip.Inflater

abstract class BaseFragment<in T> : Fragment() where T: ViewDataBinding{

    @get:LayoutRes
    protected abstract val layoutResourceLayout: Int

    lateinit var rootView: View

    abstract fun onFragmentCreated(dataBinder: T)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpViewModelStateObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val dataBinder: T
        this@BaseFragment.layoutResourceLayout.let {
            dataBinder = DataBindingUtil.inflate<T>(inflater, it, container, false)
            this@BaseFragment.onFragmentCreated(dataBinder)
        }

        rootView = dataBinder.root
        return rootView
    }

    abstract fun setUpViewModelStateObservers()
}