package com.example.samplecompose.ui.started

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.example.samplecompose.R
import com.example.samplecompose.itemComposable.LogoSection
import com.example.samplecompose.navigator.Router
import com.example.samplecompose.storage.PreferencesManager

@Composable
fun SplashScreen(navController: NavHostController) {

    val context = LocalContext.current
     val prefManager = PreferencesManager

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bgColor)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            LogoSection()
        }

    }



    Handler(Looper.getMainLooper()).postDelayed({
        if (prefManager.getEmpID() != null) {
            navController.navigate(Router.SignInScreen) {
                popUpTo(Router.DashboardScreen) { inclusive = true }
            }
//            navController.navigate(Router.DashboardScreen) {
//                popUpTo(Router.DashboardScreen) { inclusive = true }
//            }
        } else {
            navController.navigate(Router.SignInScreen) {
                popUpTo(Router.SignInScreen) { inclusive = true }
            }
        }

    }, 3000)


}

