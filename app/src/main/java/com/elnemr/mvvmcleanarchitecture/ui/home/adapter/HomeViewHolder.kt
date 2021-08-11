package com.elnemr.mvvmcleanarchitecture.ui.home.adapter

import com.elnemr.mvvmcleanarchitecture.base.adapter.BaseViewHolder
import com.elnemr.mvvmcleanarchitecture.databinding.HomeRowLayoutBinding
import com.elnemr.mvvmcleanarchitecture.models.Dummy

class HomeViewHolder(private val binding: HomeRowLayoutBinding) : BaseViewHolder<Dummy>(binding) {
    override fun bind(result: Dummy) {
        binding.dummy = result
        binding.executePendingBindings()
    }
}