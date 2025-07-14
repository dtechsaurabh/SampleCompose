package com.example.samplecompose.ui.dashboard

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.samplecompose.R
import com.example.samplecompose.itemComposable.CustomButton
import com.example.samplecompose.itemComposable.LogoSection
import com.example.samplecompose.navigator.Router
import com.example.samplecompose.storage.PreferencesManager

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview() {
    val navController = rememberNavController()
    DashboardScreen(navController)
}


@Composable
fun DashboardScreen(navController: NavHostController) {

    val context = LocalContext.current
    val prefManager = PreferencesManager
    val userEmail = prefManager.getUserEmail() ?: ""
    val userType = prefManager.getEmpType()

    BackHandler {
        (context as Activity).finish()
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(colorResource(id = R.color.bgColor))
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .background(
                    colorResource(R.color.bgColor)
                )
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            LogoSection()


            Text(
                text = "userEmail",
                color = colorResource(R.color.black),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.medium))
            )


        }

        Column(
            modifier = Modifier
                .padding(15.dp)
                .background(
                    colorResource(R.color.bgColor)
                )
        ) {

            if (userType != null) {

                if (userType == "1" || userType == "4" || userType == "5") {
                    Spacer(modifier = Modifier.height(10.dp))

                    CustomButton(buttonText = "Service Visit Reports") {
                       // navController.navigate(Router.ServiceVisitReportScreen)
                    }
                }

                if (userType == "1" || userType == "3" || userType == "5") {
                    Spacer(modifier = Modifier.height(10.dp))

                    CustomButton(buttonText = "Sales Visit Reports") {
                     //   navController.navigate(Router.SalesVisitReportScreen)
                    }
                }

                if (userType == "1" || userType == "4" || userType == "5") {
                    Spacer(modifier = Modifier.height(10.dp))

                    CustomButton(buttonText = "Add Expense" ) {
                       // navController.navigate(Router.ReportHistoryScreen)
                    }
                }

                if (userType == "1" || userType == "4" || userType == "5") {
                    Spacer(modifier = Modifier.height(10.dp))

                    CustomButton(buttonText = "Update Expense") {
                      //  navController.navigate(Router.UpdateExpenseScreen)
                    }

                }

                if (userType == "1" || userType == "2") {
                    Spacer(modifier = Modifier.height(10.dp))

                    CustomButton(buttonText = "Assign Job MLC") {
                      //  navController.navigate(Router.AssignJobMICScreen)
                    }


                }

                if (userType == "1" || userType == "2") {
                    Spacer(modifier = Modifier.height(10.dp))

                    CustomButton(buttonText = "Assign Job COLT") {
                        //navController.navigate(Router.AssignJobColtScreen)
                    }

                }

                if (userType == "1" || userType == "2") {
                    Spacer(modifier = Modifier.height(10.dp))

                    CustomButton(buttonText = "View Jobs MIC") {
                       // navController.navigate(Router.ViewJobsMICScreen)
                    }

                }

                if (userType == "1" || userType == "2") {
                    Spacer(modifier = Modifier.height(10.dp))

                    CustomButton(buttonText = "View Jobs COLT") {
                       // navController.navigate(Router.ViewJobsColtScreen)
                    }

                }

                Spacer(modifier = Modifier.height(10.dp))
            }

        }


    }

}