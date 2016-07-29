package com.example.akki.thenewshour.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.akki.thenewshour.R;
import com.example.akki.thenewshour.constants.AppConstants;
import com.example.akki.thenewshour.models.BasicResponse;
import com.example.akki.thenewshour.models.mostPopular.MostPopularResponse;
import com.example.akki.thenewshour.network.OnNetworkResponseListener;


public class SplashScreen extends BaseActivity implements OnNetworkResponseListener<BasicResponse> {

    private boolean isPermissionGranted = false;
    private static final int REQUEST_CODE_SETTINGS_CHANGE_PERMISSION = 109;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash_screen);
        getSettingsChangePermission();
        /*launchHomePageWithDelay();*/

       /* startActivity(sendDataIntent);*/
    }

    public void getSettingsChangePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.System.canWrite(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, REQUEST_CODE_SETTINGS_CHANGE_PERMISSION);
        } else {
            isPermissionGranted = true;
            launchHomePageWithDelay();
        }
    }

    private void launchHomePageWithDelay() {
        Intent sendDataIntent = new Intent(this, HomePageActivity.class);
        sendDataIntent.putExtra(AppConstants.IS_SETTINGS_PERMISSION_GRANTED, isPermissionGranted);
        sendDataIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(sendDataIntent);
    }

    @Override
    public void onDownloadComplete(int requestId, String requestUrl, BasicResponse responseData) {
        hideLoadingView();
        if (responseData.status.equalsIgnoreCase("OK")) {
            if (requestId == AppConstants.GET_MOST_POULAR_DATA) {
                MostPopularResponse mostPopularData = (MostPopularResponse) responseData;
                sendDataToNextPage(mostPopularData);
            }
        }
    }

    private void sendDataToNextPage(MostPopularResponse mostPopularData) {
        Intent sendDataIntent = new Intent(this, HomePageActivity.class);
        sendDataIntent.putExtra(AppConstants.INTENT_SPLASH_SCREEN_DATA, mostPopularData);
        sendDataIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(sendDataIntent);
    }

    @Override
    public void onDownloadFailed(int requestId, String requestUrl, VolleyError networkError) {
        hideLoadingView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SETTINGS_CHANGE_PERMISSION) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.System.canWrite(this)) {
                Toast.makeText(getApplicationContext(), "Permission not granted", Toast.LENGTH_SHORT).show();
            } else {
                isPermissionGranted = true;
                Toast.makeText(getApplicationContext(), "Permission is granted", Toast.LENGTH_SHORT).show();
            }
            launchHomePageWithDelay();
        }
    }
}

