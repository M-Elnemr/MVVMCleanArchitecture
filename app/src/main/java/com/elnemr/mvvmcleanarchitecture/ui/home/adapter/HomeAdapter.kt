package com.elnemr.mvvmcleanarchitecture.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.AsyncListDiffer
import com.elnemr.mvvmcleanarchitecture.base.adapter.BaseAdapter
import com.elnemr.mvvmcleanarchitecture.base.adapter.BaseViewHolder
import com.elnemr.mvvmcleanarchitecture.base.adapter.DiffCallBack
import com.elnemr.mvvmcleanarchitecture.databinding.HomeRowLayoutBinding
import com.elnemr.mvvmcleanarchitecture.models.Dummy

class HomeAdapter : BaseAdapter<Dummy>() {

//    private val dummyList: MutableList<Dummy> = mutableListOf()
    private var mDiffer = AsyncListDiffer<Dummy>(this, DiffCallBack<Dummy>())

    override fun setDataList(dataList: List<Dummy>) {
        mDiffer.submitList(dataList)
    }

    override fun addDataList(dataList: List<Dummy>) {
        mDiffer.currentList.addAll(dataList)
    }

    override fun clearDataList() {
        mDiffer.currentList.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Dummy> {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = HomeRowLayoutBinding.inflate(inflater)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Dummy>, position: Int) =
        holder.bind(mDiffer.currentList[position])

    override fun getItemCount(): Int = mDiffer.currentList.size
}