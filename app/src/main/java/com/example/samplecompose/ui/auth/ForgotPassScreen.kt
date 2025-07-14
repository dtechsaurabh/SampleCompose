package com.example.samplecompose.ui.auth

import android.app.Activity
import android.util.Patterns
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.samplecompose.R
import com.example.samplecompose.base.BaseViewModel
import com.example.samplecompose.itemComposable.CustomButton
import com.example.samplecompose.itemComposable.CustomEditTextField
import com.example.samplecompose.itemComposable.GlobalLoaderOverlay
import com.example.samplecompose.itemComposable.LogoSection
import com.example.samplecompose.utils.MessageUtils
import kotlinx.coroutines.launch

@Composable
fun ForgotPassScreen(
    navController: NavHostController,
    viewModel: BaseViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var userEmail by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    BackHandler {
        (context as Activity).finish()
    }

    if (isLoading) GlobalLoaderOverlay()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bgColor))
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            LogoSection()
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.forgot_password),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.semibold)),
                color = colorResource(R.color.mainColor),
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(R.string.email),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Left,
                fontFamily = FontFamily(Font(R.font.semibold)),
                color = colorResource(R.color.black),
                fontSize = 16.sp
            )

            CustomEditTextField(
                value = userEmail,
                onValueChange = { userEmail = it },
                label = stringResource(R.string.email),
                placeholder = stringResource(R.string.enter_your_email),
                iconRes = R.drawable.email_icon,
                colorRes = R.color.editFieldColor,
                keyboardType = KeyboardType.Email,
                enabled = true,
                showText = true,
            )

            Spacer(modifier = Modifier.height(35.dp))

            CustomButton(buttonText = stringResource(R.string.send_reset_link)) {
                when {
                    userEmail.isBlank() -> {
                        MessageUtils.showShortToast(context, "Please enter your email")
                    }

                    !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() -> {
                        MessageUtils.showShortToast(context, "Invalid email address")
                    }

                    else -> {
                        isLoading = true

                        // Simulate network request using coroutine
//                        scope.launch {
//                            val result = viewModel.sendResetLink(userEmail)
//                            isLoading = false
//
//                            if (result.isSuccess) {
//                                MessageUtils.showShortToast(context, "Reset link sent to your email")
//                                // navController.popBackStack() // go back if needed
//                            } else {
//                                MessageUtils.showShortToast(
//                                    context,
//                                    result.exceptionOrNull()?.localizedMessage ?: "Failed to send reset link"
//                                )
//                            }
//                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ForgotPassScreenPreview() {
    val navController = rememberNavController()
    ForgotPassScreen(navController)
}
