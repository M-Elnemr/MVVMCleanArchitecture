package com.elnemr.mvvmcleanarchitecture.base

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(response: T) : NetworkResult<T>(response)
    class Error<T>(message: String?, response: T? = null): NetworkResult<T>(response, message)
    class Loading<T>: NetworkResult<T>()
    class Empty<T>: NetworkResult<T>()
    class NoInternet<T>: NetworkResult<T>()
}