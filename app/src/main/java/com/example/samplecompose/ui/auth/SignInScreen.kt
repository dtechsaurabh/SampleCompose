package com.example.samplecompose.ui.auth

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.samplecompose.itemComposable.LogoSection
import com.example.samplecompose.R
import com.example.samplecompose.itemComposable.CustomButton
import com.example.samplecompose.itemComposable.CustomEditTextField
import com.example.samplecompose.itemComposable.GlobalLoaderOverlay
import com.example.samplecompose.storage.PreferencesManager


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInScreenPreview() {
    val navController = rememberNavController()
    SignInScreen(navController)
}


@Composable
fun SignInScreen(navController: NavHostController) {

    var context = LocalContext.current
    var userEmail by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
   // var userViewModel: UserViewModel = hiltViewModel()

    BackHandler {
        (context as Activity).finish()
    }

  //  val prefManager = PreferencesManager(context)
    val prefManager = PreferencesManager


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
                text = stringResource(R.string.sign_in),
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

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(R.string.password),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Left,
                fontFamily = FontFamily(Font(R.font.semibold)),
                color = colorResource(R.color.black),
                fontSize = 16.sp
            )

            CustomEditTextField(
                value = userPassword,
                onValueChange = { userPassword = it },
                label = stringResource(R.string.password),
                placeholder = stringResource(R.string.enter_your_password),
                iconRes = R.drawable.password_icon,
                colorRes = R.color.editFieldColor,
                keyboardType = KeyboardType.Password,
                enabled = true,
                showText = false,
            )


            Spacer(modifier = Modifier.height(35.dp))

            CustomButton(buttonText = stringResource(R.string.sign_in)) {

//                userViewModel.logIn(userEmail, userPassword) { responsePair ->
//                    val response = responsePair.first
//                    val message = responsePair.second
//                    printLog("response => $response")
//                    if (response != null) {
//                        prefManager.setUserEmail(userEmail)
//                        prefManager.setUserEmail(userPassword)
//                        prefManager.setEmpId(response.get("emp_id").asString)
//                        prefManager.setEmpStatus(response.get("emp_status").asString)
//                        prefManager.setEmpType(response.get("emp_type").asString)
//                        prefManager.setUsername(response.get("name").asString)
//                        navController.navigate(Router.DashboardScreen)
//                    } else {
//                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//                    }
//                }

            }



        }
    }


}

