package com.example.samplecompose.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.samplecompose.MyApplication
import com.example.samplecompose.network.NetworkLiveData
import com.example.samplecompose.network.NetworkObserver
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn


open class BaseViewModel : ViewModel() {

    // Use NetworkObserver's StateFlow directly
    val isNetworkAvailable: StateFlow<Boolean> = NetworkObserver.isConnected
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false // or true if you prefer
        )

    // No manual checking method needed since NetworkObserver updates automatically
}

