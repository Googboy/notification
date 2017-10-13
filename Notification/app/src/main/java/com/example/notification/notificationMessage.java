package com.example.notification;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by 潘硕 on 2017/10/13.
 */

public class notificationMessage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView t = new TextView(this);
        t.setText("这是一条通知信息");
        setContentView(t);
    }
}
