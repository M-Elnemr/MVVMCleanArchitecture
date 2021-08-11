package com.elnemr.mvvmcleanarchitecture.models

data class DummyModel (
    var dummyList: List<Dummy> = listOf()
)

data class Dummy(
    var id: Int = 0,
    var name: String = ""
)