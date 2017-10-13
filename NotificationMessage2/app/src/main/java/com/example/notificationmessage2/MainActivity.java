package com.example.notificationmessage2;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final int NOTIFICATION_FLAG = 1;
    //private static final int NOTIFICATION_FLAG=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.btnDefault);
        Button button2 = (Button) findViewById(R.id.btnDefaultAPI11);
        Button button3 = (Button) findViewById(R.id.btnDefaultAPI16);
        Button button4 = (Button) findViewById(R.id.btnSelf);
        Button button5 = (Button) findViewById(R.id.btnClear);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        switch (v.getId()){
            case R.id.btnDefault:
                PendingIntent pendingIntent = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
                Notification notification = new Notification();
                notification.icon = R.mipmap.ic_launcher;
                notification.tickerText = "TickerText:你有新短信，请注意查收!";
                notification.when = System.currentTimeMillis();
                //notification.setLatestEventInfo(this,"Notification Title","这是一条通知信息",pendingIntent);
                notification.number=1;
                notification.flags |= Notification.FLAG_AUTO_CANCEL;
                manager.notify(NOTIFICATION_FLAG,notification);
                break;
            case R.id.btnDefaultAPI11:
                PendingIntent pendingIntent2 = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
                Notification notification2 = new Notification.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setTicker("你有新短消息，请查收!")
                        .setContentTitle("通知标题")
                        .setContentText("这是通知消息的内容")
                        .setContentIntent(pendingIntent2)
                        .setNumber(1)
                        .getNotification();
                notification2.flags |= Notification.FLAG_AUTO_CANCEL;
                manager.notify(NOTIFICATION_FLAG,notification2);
                break;
            case R.id.btnDefaultAPI16:
            PendingIntent pendingIntent3 = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
            Notification notification3 = new Notification.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setTicker("你有新短消息，请查收!")
                    .setContentTitle("通知标题")
                    .setContentText("这是通知消息的内容")
                    .setContentIntent(pendingIntent3)
                    .setNumber(1)
                    .build();
            notification3.flags |= Notification.FLAG_AUTO_CANCEL;
            manager.notify(NOTIFICATION_FLAG,notification3);
            break;
            case R.id.btnSelf:
                Notification myNotify = new Notification();
                myNotify.icon = R.mipmap.ic_launcher;
                myNotify.tickerText = "你有短消息，请注意查收!";
                myNotify.when = System.currentTimeMillis();
                myNotify.flags = Notification.FLAG_NO_CLEAR;
                RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.my_notification);
                remoteViews.setTextViewText(R.id.text_content,"这是自定义短消息的内容");//因为自定义的xml文件里面就设置了一个edittext，所以说当你点击自定义的时候就只显示一个文本。
                myNotify.contentView = remoteViews;
                Intent intent = new Intent(Intent.ACTION_MAIN);
                PendingIntent contentIntent = PendingIntent.getActivity(this,1,intent,0);
                myNotify.contentIntent = contentIntent;
                manager.notify(NOTIFICATION_FLAG,myNotify);
                break;
            case R.id.btnClear:
                manager.cancel(NOTIFICATION_FLAG);
                break;
            default:
                break;

        }
    }
}
