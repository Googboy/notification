package com.example.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private NotificationManager mgr = null;
    int count = 0;
    private static final int NOTIFY_ME_ID = 1337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button notifyMe = (Button) findViewById(R.id.btnSend);
        notifyMe.setOnClickListener(this);
        Button clearNotify = (Button) findViewById(R.id.btnClear);
        clearNotify.setOnClickListener(this);

        mgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
/*
    public  void notigyMe(View v){
        count++;
        PendingIntent i = PendingIntent.getActivity(this,0,new Intent(this,notificationMessage.class),0);
        Notification myNotify = new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("Ticker"+count)
                .setContentTitle("Title"+count)
                .setContentText("通知文本"+count)
                .setContentIntent(i)
                .setNumber(count)
                .build();
        myNotify.flags |=Notification.FLAG_AUTO_CANCEL;
        mgr.notify(NOTIFY_ME_ID,myNotify);
    }
    public  void notifyClear(View v){
        mgr.cancel(NOTIFY_ME_ID);
    }
*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSend:
                count++;
                //创建一个PendingIntent，和Intent类似，不同的是由于不是马上调用，需要在下拉状态条是出发的activity，所以采用的是PendingIntent
                PendingIntent i = PendingIntent.getActivity(this,0,new Intent(this,notificationMessage.class),0);
                //Notification.Builder提供了setLights( ),setSound( ),setVibrate()等方法,依次是灯光，声音和震动，都可以在下面设置添加进去
                Notification myNotify = new Notification.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setTicker("Ticker"+count) //设置在status bar上显示的提示文字
                        .setContentTitle("Title通知标题"+count)//通知消息的标题
                        .setContentText("这是测试通知文本，里面应该包含的是通知的内容"+count)
                        .setContentIntent(i)
                        .setNumber(count)
                        .build();
                myNotify.flags |=Notification.FLAG_AUTO_CANCEL;
                mgr.notify(NOTIFY_ME_ID,myNotify);
                break;
            case R.id.btnClear:
                mgr.cancel(NOTIFY_ME_ID);
                break;
        }
    }

}
