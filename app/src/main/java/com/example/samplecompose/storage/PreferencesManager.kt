package com.example.samplecompose.storage

import android.content.Context
import android.content.SharedPreferences

object PreferencesManager {
    private const val PREF_NAME = "MyApplication"
    private lateinit var sharedPreferences: SharedPreferences

    var IsLogin = "loginuser"
    private const val KEY_USER_Id = "USER_ID"
    private const val KEY_USER_NAME = "USER_NAME"
    private const val KEY_USER_EMAIL = "USER_EMAIL"
    private const val KEY_USER_MOBILE = "USER_MOBILE"
    private const val KEY_USER_IMAGE = "USER_IMAGE"
    private const val KEY_USER_CAT = "USER_CATEGORY"
    private const val IMAGE = "IMAGE"
    private const val KEY_EMP_TYPE = "emp_type"


    private const val KEY_FCM_TOKEN = "FCM_TOKEN"


    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveBooleanData(key :String,value : Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key,value)
        editor.apply()
    }

    fun getBooleanData(key:String) : Boolean{
        return sharedPreferences.getBoolean(key,false)
    }
    fun getEmpID(): String? {
        return "100001"
        // return preferences.getString(KEY_EMP_ID, null)
    }
    // Save all user data
    /*fun saveUserData(user: OtpData) {
        with(sharedPreferences.edit()) {
            putString(KEY_USER_NAME, user.name)
            putString(KEY_USER_EMAIL, user.email)
            putString(KEY_USER_MOBILE, user.mobile)
            putString(KEY_USER_IMAGE, user.image5)
            apply()
        }
    }*/


    fun getUserId(): Long? = sharedPreferences.getLong(KEY_USER_Id, 0)
    fun getUserName(): String? = sharedPreferences.getString(KEY_USER_NAME, null)
    fun getUserEmail(): String? = sharedPreferences.getString(KEY_USER_EMAIL, null)
    fun getUserMobile(): String? = sharedPreferences.getString(KEY_USER_MOBILE, null)
    fun getUserImage(): String? = sharedPreferences.getString(KEY_USER_IMAGE, null)
    fun getUserCategory(): String? = sharedPreferences.getString(KEY_USER_CAT, null)
    fun getImage(): String? = sharedPreferences.getString(IMAGE, null)

    fun clearUserData() {
        sharedPreferences.edit().clear().apply()
    }
    fun getEmpType(): String? {
       // return preferences.getString(KEY_EMP_TYPE, null)
        return sharedPreferences.getString(KEY_USER_IMAGE, null)

    }
    // Add to Preference object
    fun saveUserImagePath(path: String) {
        sharedPreferences.edit().putString(IMAGE, path).apply()
    }

    fun getUserImagePath(): String? {
        return sharedPreferences.getString(KEY_USER_IMAGE, null)
    }

    fun saveFCMToken(token: String) {
        sharedPreferences.edit().putString(KEY_FCM_TOKEN, token).apply()
    }

    fun getFCMToken(): String? {
        return sharedPreferences.getString(KEY_FCM_TOKEN, null)
    }




}