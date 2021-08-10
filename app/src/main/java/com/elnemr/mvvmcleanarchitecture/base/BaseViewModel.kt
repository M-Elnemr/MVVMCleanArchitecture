package com.elnemr.mvvmcleanarchitecture.base

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import retrofit2.Response

abstract class BaseViewModel(private val application: Application) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.M)
    fun hasInternetConnection(): Boolean {
        val connectivityManager = application.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    fun<T> handleResponse(response: Response<T>): NetworkResult<T> {
        return when {
            response.code() == 200 && response.isSuccessful && response.body() == null -> NetworkResult.Empty()
            response.code() == 200 && response.isSuccessful -> NetworkResult.Success(response.body()!!)
            response.message().toString().contains("timeout") -> NetworkResult.Error("TimeOut")
            else -> NetworkResult.Error(response.message())
        }
    }

}