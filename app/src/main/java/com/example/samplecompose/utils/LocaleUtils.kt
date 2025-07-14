@file:Suppress("DEPRECATION")

package com.example.samplecompose.utils

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

object LocaleUtils {


    fun setLocale(context: Context, languageCode: String): Context {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        // Modify the configuration
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)

        // Update the resources with the new configuration
        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        return context
    }
    //        LoaderState.show()
    //  LoaderState.hide()
}
