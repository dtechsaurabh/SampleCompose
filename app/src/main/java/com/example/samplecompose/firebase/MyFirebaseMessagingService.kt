package com.example.samplecompose.firebase
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import kotlin.text.isNullOrEmpty

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("fcm token", "onNewToken: $token")
        Log.d("fcm token1", "onNewToken: $token")

        saveFcmTokenToPreference(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d("fcm message", "onMessageReceived: ${remoteMessage.data}")


        if (remoteMessage.data.isNotEmpty()) {
            val title = remoteMessage.data["title"] ?: "Notification"
            val message = remoteMessage.data["body"] ?: ""
            val imageUrl = remoteMessage.data["image"]

            if (!imageUrl.isNullOrEmpty()) {
                saveNotificationToDatabase(title, message, imageUrl)
                showImageNotification(title, message, imageUrl)
            } else {
                showNotification(title, message)
                saveNotificationToDatabase(title, message, null)
            }
        }

            remoteMessage.notification?.let {
                val title = it.title ?: "Notification"
                val message = it.body ?: ""
                val imageUrl = it.imageUrl.toString()

                if (!imageUrl.isNullOrEmpty()) {
                    Log.d("FCM Notification", "Image URL: $imageUrl")
                    saveNotificationToDatabase(title, message, imageUrl)
                    showImageNotification(title, message, imageUrl)
                } else {
                    saveNotificationToDatabase(title, message, null)
                    showNotification(title, message)
                }
        }
    }

    private fun showNotification(title: String, message: String) {
        val channelId = "fcm_channel"
//        val builder = NotificationCompat.Builder(this, channelId)
//            .setSmallIcon(R.drawable.ic_notification_overlay)
//            .setContentTitle(title)
//            .setContentText(message)
//            .setContentIntent(getPendingIntent())
//            .setPriority(NotificationCompat.PRIORITY_HIGH)

        //val manager = ContextWrapper.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "FCM Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
       //     manager.createNotificationChannel(channel)
        }

     //   manager.notify(0, builder.build())
    }

    private fun showImageNotification(title: String, message: String, imageUrl: String?) {
        val channelId = "fcm_channel"

//        val builder = NotificationCompat.Builder(this, channelId)
//            .setSmallIcon(R.drawable.adfw_logo)
//            .setContentTitle(title)
//            .setContentText(message)
//            .setContentIntent(getPendingIntent())
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setAutoCancel(true)

        if (!imageUrl.isNullOrEmpty()) {
            try {
                val url = URL(imageUrl)
                val connection = url.openConnection()
                connection.doInput = true
                connection.connect()
                val inputStream = connection.getInputStream()
                val bitmap = BitmapFactory.decodeStream(inputStream)
//
//                builder.setStyle(
//                    NotificationCompat.BigPictureStyle()
//                        .bigPicture(bitmap)
//                        .bigLargeIcon(null as Bitmap)
//                )
            } catch (e: Exception) {
                e.printStackTrace()
                // fallback to text-only if image fails to load
            //    builder.setStyle(NotificationCompat.BigTextStyle().bigText(message))
            }
        } else {
          //  builder.setStyle(NotificationCompat.BigTextStyle().bigText(message))
        }

      //  val manager = ContextWrapper.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "FCM Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
         //   manager.createNotificationChannel(channel)
        }

       // manager.notify(System.currentTimeMillis().toInt(), builder.build()) // use unique ID
    }


//    private fun getPendingIntent(): PendingIntent {
//        val intent = Intent(this, SplashScreen::class.java).apply {
//            Intent.setFlags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
//        return PendingIntent.getActivity(
//            this,
//            0,
//            intent,
//            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
//        )
//    }

    fun saveFcmTokenToPreference(token: String){

   //     PreferenceManager.init(ContextWrapper.getApplicationContext)
   //     PreferenceManager.saveFCMToken(token)

    }

    private fun saveNotificationToDatabase(title: String, message: String, imageUrl: String?) {

        Log.d("myfirebaseclass", "saveNotificationToDatabase: ${title}${message}")
//        val notification = NotificationEntity(
//            tittle = title,
//            message = message,
//            imageUrl = imageUrl
//        )

        CoroutineScope(Dispatchers.IO).launch {
           // val db = AppDatabase.getInstance(ContextWrapper.getApplicationContext)
           // db.notificationDao().insertNotification(notification)
        }
    }

}