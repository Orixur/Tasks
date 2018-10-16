package com.example.improve.tasks3.firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.improve.tasks3.R;
import com.example.improve.tasks3.ui.activity.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.app.NotificationChannel.DEFAULT_CHANNEL_ID;

public class MiFirebaseMessagingService extends FirebaseMessagingService
{
    String tag = "Noticias";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);



        String from = remoteMessage.getFrom();
        Log.d(tag, "Mensaje recibido de: " + from);

        if(remoteMessage.getNotification() != null)
        {
            Log.d(tag, "Notificacion: " + remoteMessage.getNotification().getBody());

            mostrarNotificacion(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        }

        if(remoteMessage.getData() != null)
        {
            Log.d(tag, "Data: " + remoteMessage.getData());
        }
    }

    private void mostrarNotificacion(String title, String body)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        /*
        Notification notificationBuilder = new NotificationCompat.Builder(this,	DEFAULT_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_menu_send)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationBuilder.notify(0,notificationBuilder);
        */

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, DEFAULT_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_menu_send)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d(tag,"String desde service: " + s);
    }
}
