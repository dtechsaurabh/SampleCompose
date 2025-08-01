//package com.example.samplecompose.storage.roomdb
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//
//@Database(entities = [NotificationEntity::class], version = 1, exportSchema = false)
//abstract class AppDatabase : RoomDatabase() {
//
//    abstract fun notificationDao() : NotificationDao
//
//    companion object{
//        @Volatile private var INSTANCE : AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                INSTANCE ?: Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                ).build().also { INSTANCE = it }
//            }
//        }
//    }
//}