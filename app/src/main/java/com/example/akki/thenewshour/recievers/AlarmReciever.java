package com.example.akki.thenewshour.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.akki.thenewshour.utils.AppUtils;
import com.example.akki.thenewshour.utils.NewsFeedDatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;

/**
 * Created by akki on 13/1/16.
 */
public class AlarmReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        AppUtils.clearSavedImages(context);

    }
}
