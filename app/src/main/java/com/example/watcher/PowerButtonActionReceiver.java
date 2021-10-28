package com.example.watcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class PowerButtonActionReceiver extends BroadcastReceiver {
    private static final String TAG = "PowerButtonActionReceiv";
    private long lastClickedTimestamp = 0;
    private int clickCnt = 0;

    public PowerButtonActionReceiver() {
        lastClickedTimestamp = System.currentTimeMillis();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        long currentTimestamp = System.currentTimeMillis();
        Log.d(TAG, "onReceive: "+(currentTimestamp - lastClickedTimestamp));
        int interval = 500;
        if(Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
            if(currentTimestamp-lastClickedTimestamp <=interval)
                clickCnt++;
            else
                clickCnt = 0;
            lastClickedTimestamp = System.currentTimeMillis();
            Log.d(TAG, "onReceive: screen off. cnt: "+clickCnt);
            Toast.makeText(context, "screen off", Toast.LENGTH_SHORT).show();
        }else if(Intent.ACTION_SCREEN_ON.equals(intent.getAction())){
            if(currentTimestamp-lastClickedTimestamp <=interval)
                clickCnt++;
            else clickCnt = 0;
            lastClickedTimestamp = System.currentTimeMillis();
            Log.d(TAG, "onReceive: screen on: "+clickCnt);
            Toast.makeText(context, "screen on", Toast.LENGTH_SHORT).show();
        }
    }
}
