package com.elnemr.mvvmcleanarchitecture.base.adapter

import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    abstract fun setDataList(dataList: List<T>)

    abstract fun addDataList(dataList: List<T>)

    abstract fun clearDataList()

}