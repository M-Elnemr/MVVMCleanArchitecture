package com.elnemr.mvvmcleanarchitecture.base.view

import androidx.lifecycle.Lifecycle
import android.content.Context
import android.content.res.Resources
import android.view.View
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewSlice : ViewSlice, LayoutContainer {

    protected lateinit var context: Context
    protected lateinit var resources: Resources

    override lateinit var containerView: View

    override fun init(lifecycle: Lifecycle, view: View) {
        context = view.context
        resources = view.resources
        containerView = view
        lifecycle.addObserver(this)
//        ViewCompat.setLayoutDirection(view, ViewCompat.LAYOUT_DIRECTION_RTL)
    }

    companion object {
        const val STATE_CONTENT = 0
        const val STATE_LOADING = 1
        const val STATE_ERROR = 2
    }
}
