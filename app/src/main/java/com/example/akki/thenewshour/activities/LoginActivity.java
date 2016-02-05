package com.example.akki.thenewshour.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.akki.thenewshour.R;
import com.example.akki.thenewshour.constants.AppConstants;
import com.example.akki.thenewshour.utils.LogUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by akki on 20/1/16.
 */
public class LoginActivity extends BaseActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {
    private GoogleApiClient mGoogleApiClient;
    private TextView mUserName;
    private ImageView mUserPic;
    private GoogleSignInAccount mAcct;
    private String mImageUrl;
    private boolean isLoginSuccess = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login_activity);
        init();
        setGoogleSignInRequest();
        setListeners();
    }

    private void setListeners() {
        findViewById(R.id.sign_in_button).setOnClickListener(this);
    }

    private void setGoogleSignInRequest() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    private void init() {
        mUserName = (TextView) findViewById(R.id.tv_user_name);
        mUserPic = (ImageView) findViewById(R.id.iv_user_pic);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
        }
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, AppConstants.GET_GMAIL_LOGIN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == AppConstants.GET_GMAIL_LOGIN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            mAcct = result.getSignInAccount();
            mImageUrl = mAcct.getPhotoUrl().toString();
            isLoginSuccess = true;

        } else {
            isLoginSuccess = false;
        }
        updateUI();
    }

    private void updateUI() {
        if (isLoginSuccess) {
            mUserName.setText(mAcct.getDisplayName());

        }
    }

    @Override
    public void onBackPressed() {
        if (isLoginSuccess) {
            Intent intent = new Intent();
            intent.putExtra(AppConstants.USER_DISPLAY_PIC, mImageUrl);
            setResult(RESULT_OK, intent);
        } else {
            setResult(RESULT_CANCELED);
        }
        super.onBackPressed();
    }
}
