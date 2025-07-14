package com.example.samplecompose.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.samplecompose.ui.auth.SignInScreen
import com.example.samplecompose.ui.dashboard.DashboardScreen
import com.example.samplecompose.ui.started.SplashScreen
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Composable
fun NavHostApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Router.SplashScreen) {
        ->

        composable<Router.SplashScreen> {
            SplashScreen(navController)
        }

        composable<Router.SignInScreen> {
            SignInScreen(navController)
        }

        composable<Router.DashboardScreen> {
           DashboardScreen(navController)
        }
//
//        composable<Router.ServiceVisitReportScreen> {
//            ServiceVisitReportScreen(navController)
//        }
//
//        composable<Router.ServiceSearchResultScreen> { backStackEntry ->
//            val screen = backStackEntry.toRoute<Router.ServiceSearchResultScreen>()
//            val searchKeyword = screen.searchKeyword
//            ServiceSearchResultScreen(navController, searchKeyword)
//        }
//
//        composable<Router.ServiceFormSubmitScreen> { backStackEntry ->
//            val screen = backStackEntry.toRoute<Router.ServiceFormSubmitScreen>()
//            val reportId = screen.reportId
//            ServiceFormSubmitScreen(navController, reportId)
//        }
//
//        composable<Router.ServiceFormScreen> { backStackEntry ->
//            val screen = backStackEntry.toRoute<Router.ServiceFormScreen>()
//            val gson = Gson()
//            val type = object : TypeToken<ServiceClient>() {}.type
//            val serviceClient: ServiceClient = gson.fromJson(screen.serviceClient, type)
//            ServiceFormScreen(navController, serviceClient)
//        }
//
//        composable<Router.ReportHistoryScreen> {
//            ReportHistoryScreen(navController)
//        }
//
//        composable<Router.AddExpenseScreen> {
//            AddExpenseScreen(navController)
//        }
//
//        composable<Router.UpdateExpenseScreen> {
//            UpdateExpenseScreen(navController)
//        }
//
//        composable<Router.AssignJobMICScreen> {
//            AssignJobMICScreen(navController)
//        }
//
//        composable<Router.AssignJobColtScreen> {
//            AssignJobColtScreen(navController)
//        }
//
//        composable<Router.ViewJobsMICScreen> {
//            ViewJobsMICScreen(navController)
//        }
//
//        composable<Router.ViewJobsColtScreen> {
//            ViewJobsColtScreen(navController)
//        }
//
//        composable<Router.TaskDetailsMICScreen> { backStackEntry ->
//            val screen = backStackEntry.toRoute<Router.TaskDetailsMICScreen>()
//            val jobId = screen.jobId
//            TaskDetailsMICScreen(navController, jobId)
//        }
//
//        composable<Router.TaskDetailsColtScreen> { backStackEntry ->
//            val screen = backStackEntry.toRoute<Router.TaskDetailsColtScreen>()
//            val jobId = screen.jobId
//            TaskDetailsColtScreen(navController, jobId)
//        }
//
//        composable<Router.UpdateJobDetailsColtScreen> { backStackEntry ->
//            val screen = backStackEntry.toRoute<Router.UpdateJobDetailsColtScreen>()
//            val jobId = screen.jobId
//            UpdateJobDetailsColtScreen(navController,jobId)
//        }
//
//        composable<Router.UpdateJobDetailsMICScreen> { backStackEntry ->
//            val screen = backStackEntry.toRoute<Router.UpdateJobDetailsMICScreen>()
//            val jobId = screen.jobId
//            UpdateJobDetailsMICScreen(navController, jobId)
//        }
//
//        composable<Router.SalesVisitReportScreen> {
//            SalesVisitReportScreen(navController)
//        }
//        composable<Router.SalesSearchResultScreen> { backStackEntry ->
//            val screen = backStackEntry.toRoute<Router.SalesSearchResultScreen>()
//            val searchKeyword = screen.searchKeyword
//            SalesSearchResultScreen(navController, searchKeyword)
//
//        }
//
//        composable<Router.SalesFormScreen> { backStackEntry ->
//            val screen = backStackEntry.toRoute<Router.SalesFormScreen>()
//            val gson = Gson()
//            val type = object : TypeToken<SalesCompany>() {}.type
//            val salesClient: SalesCompany = gson.fromJson(screen.salesClient, type)
//            SalesFormScreen(navController, salesClient)
//        }


    }


}