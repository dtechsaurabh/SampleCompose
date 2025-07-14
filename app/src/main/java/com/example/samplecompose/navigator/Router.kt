package com.example.samplecompose.navigator

import kotlinx.serialization.Serializable

sealed class Router {

    @Serializable
    object SplashScreen


    @Serializable
    object SignInScreen

    @Serializable
    object DashboardScreen
//
//    @Serializable
//    object ServiceVisitReportScreen
//
//    @Serializable
//    data class ServiceSearchResultScreen(
//        var searchKeyword : String
//    )
//
//    @Serializable
//    data class ServiceFormScreen(
//        val serviceClient: String,
//    )
//
//   @Serializable
//    data class ServiceFormSubmitScreen(
//        val reportId: String,
//    )
//
//    @Serializable
//    object ReportHistoryScreen
//
//    @Serializable
//    object AddExpenseScreen
//
//    @Serializable
//    object UpdateExpenseScreen
//
//    @Serializable
//    object AssignJobMICScreen
//
//    @Serializable
//    object AssignJobColtScreen
//
//    @Serializable
//    object ViewJobsMICScreen
//
//    @Serializable
//    object ViewJobsColtScreen
//
//    @Serializable
//    data class TaskDetailsMICScreen(
//        val jobId : String
//    )
//
//    @Serializable
//    data class TaskDetailsColtScreen(
//        val jobId : String
//    )
//
//
//    @Serializable
//    data class UpdateJobDetailsColtScreen(
//        val jobId : String,
//    )
//
//
//    @Serializable
//    data class UpdateJobDetailsMICScreen(
//        val jobId : String,
//    )
//
//    @Serializable
//    object SalesVisitReportScreen
//
//    @Serializable
//    data class SalesSearchResultScreen(
//        var searchKeyword : String
//    )
//
//    @Serializable
//    data class SalesFormScreen(
//        val salesClient: String,
//    )


}