package com.example.samplecompose.ui.home

import com.example.samplecompose.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    fun onRetryClicked() {
        // No manual network check needed
        // You can handle retry logic here
    }

    // Other logic...
}
