package com.example.mc;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WifiNotificationActivity extends AppCompatActivity
{
    private Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        appContext = this.getApplicationContext();
        setContentView(R.layout.activity_wifi_notification);
        onWifi();
        Button button = findViewById(R.id.checkButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onWifi();
            }
        });
    }

    public void onWifi()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkStatus = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkStatus != null &&
                networkStatus.isConnectedOrConnecting()&&
                networkStatus.getType() == ConnectivityManager.TYPE_WIFI;

        TextView textView = findViewById(R.id.wifiNotificationText);
        if(isConnected)
        {
            textView.setTextColor(Color.BLUE);
            textView.setText("Your wifi is ON.");
        }
        else
        {
            textView.setText("Your wifi is OFF.");
            textView.setTextColor(Color.RED);
        }
    }
}
