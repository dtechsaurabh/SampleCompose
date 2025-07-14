package com.example.samplecompose

import android.app.Application
import com.example.samplecompose.storage.PreferencesManager
import com.example.samplecompose.network.NetworkObserver
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize network observer singleton
        NetworkObserver.init(this)
        // Other app-level initializations
        //FirebaseApp.initializeApp(this)
       // AndroidThreeTen.init(this)
        PreferencesManager.init(this)
    }
}
