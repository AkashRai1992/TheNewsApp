package com.example.akki.thenewshour.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.akki.thenewshour.BuildConfig;
import com.example.akki.thenewshour.constants.AppConstants;
import com.example.akki.thenewshour.constants.UrlConfig;
import com.example.akki.thenewshour.debug.InAppExceptionHandler;
import com.example.akki.thenewshour.utils.LogUtils;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender;


@ReportsCrashes(httpMethod = HttpSender.Method.PUT,
        formUri = UrlConfig.ACRA_URL,
        customReportContent = {
                ReportField.APP_VERSION_CODE,
                ReportField.APP_VERSION_NAME,
                ReportField.ANDROID_VERSION,
                ReportField.PACKAGE_NAME,
                ReportField.REPORT_ID,
                ReportField.BUILD,
                ReportField.STACK_TRACE
        },
        mode = ReportingInteractionMode.TOAST
)
public class AppController extends Application {

    private final static String TAG = LogUtils.makeLogTag(AppController.class);


    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new InAppExceptionHandler(getApplicationContext()));
        if (!BuildConfig.DEBUG) {
            ACRA.init(this);
        }
    }


}
