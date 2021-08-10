package com.elnemr.mvvmcleanarchitecture.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import android.view.View

interface ViewSlice : LifecycleObserver {

    fun init(lifecycle: Lifecycle, view: View)
}
