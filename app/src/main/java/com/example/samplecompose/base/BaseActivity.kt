package com.example.samplecompose.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.samplecompose.MyApplication
import com.example.samplecompose.utils.MessageUtils

import androidx.lifecycle.lifecycleScope
import com.example.samplecompose.network.NetworkObserver
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            NetworkObserver.isConnected.collectLatest { isConnected ->
                if (!isConnected) {
                    // Show global no internet toast/snackbar/dialog
                    MessageUtils.showShortToast(this@BaseActivity, "No internet connection")
                } else {
                    // Optionally dismiss or notify reconnection
                }
            }
        }
    }
}

