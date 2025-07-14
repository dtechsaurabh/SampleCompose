package com.example.samplecompose.ui.auth

import android.app.Activity
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.samplecompose.R
import com.example.samplecompose.itemComposable.CustomButton
import com.example.samplecompose.itemComposable.CustomEditTextField
import com.example.samplecompose.itemComposable.GlobalLoaderOverlay
import com.example.samplecompose.itemComposable.LogoSection

@Composable
fun ChangePassScreen(navController: NavHostController) {
    val context = LocalContext.current
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    BackHandler {
        (context as Activity).finish()
    }

    GlobalLoaderOverlay()

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
                text = stringResource(R.string.change_password),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.semibold)),
                color = colorResource(R.color.mainColor),
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.old_password),
                fontFamily = FontFamily(Font(R.font.semibold)),
                fontSize = 16.sp,
                color = colorResource(R.color.black),
                modifier = Modifier.fillMaxWidth()
            )
            CustomEditTextField(
                value = oldPassword,
                onValueChange = { oldPassword = it },
                label = stringResource(R.string.old_password),
                placeholder = stringResource(R.string.enter_old_password),
                iconRes = R.drawable.password_icon,
                colorRes = R.color.editFieldColor,
                keyboardType = KeyboardType.Password,
                enabled = true,
                showText = false
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(R.string.new_password),
                fontFamily = FontFamily(Font(R.font.semibold)),
                fontSize = 16.sp,
                color = colorResource(R.color.black),
                modifier = Modifier.fillMaxWidth()
            )
            CustomEditTextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                label = stringResource(R.string.new_password),
                placeholder = stringResource(R.string.enter_new_password),
                iconRes = R.drawable.password_icon,
                colorRes = R.color.editFieldColor,
                keyboardType = KeyboardType.Password,
                enabled = true,
                showText = false
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(R.string.confirm_password),
                fontFamily = FontFamily(Font(R.font.semibold)),
                fontSize = 16.sp,
                color = colorResource(R.color.black),
                modifier = Modifier.fillMaxWidth()
            )
            CustomEditTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = stringResource(R.string.confirm_password),
                placeholder = stringResource(R.string.re_enter_new_password),
                iconRes = R.drawable.password_icon,
                colorRes = R.color.editFieldColor,
                keyboardType = KeyboardType.Password,
                enabled = true,
                showText = false
            )

            Spacer(modifier = Modifier.height(35.dp))

            CustomButton(buttonText = stringResource(R.string.update_password)) {
                // TODO: Validate and send oldPassword, newPassword, confirmPassword to ViewModel
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChangePassScreenPreview() {
    val navController = rememberNavController()
    ChangePassScreen(navController)
}
