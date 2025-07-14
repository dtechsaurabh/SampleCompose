package com.example.samplecompose.network

import android.content.Context
import android.net.*
import androidx.lifecycle.LiveData

class NetworkLiveData private constructor(context: Context) : LiveData<Boolean>() {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            postValue(true)
        }

        override fun onLost(network: Network) {
            postValue(false)
        }

        override fun onUnavailable() {
            postValue(false)
        }
    }

    private val networkRequest = NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()

    override fun onActive() {
        super.onActive()
        checkManually()
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    fun isNetworkAvailable(): Boolean {
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    fun checkManually() {
        val activeNetwork = connectivityManager.activeNetworkInfo
        postValue(activeNetwork != null && activeNetwork.isConnected)
    }

    companion object {
        @Volatile
        private var instance: NetworkLiveData? = null

        fun getInstance(context: Context): NetworkLiveData {
            return instance ?: synchronized(this) {
                instance ?: NetworkLiveData(context.applicationContext).also { instance = it }
            }
        }
    }
}
