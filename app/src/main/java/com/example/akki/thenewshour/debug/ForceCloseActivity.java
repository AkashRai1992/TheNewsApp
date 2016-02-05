package com.example.akki.thenewshour.debug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.akki.thenewshour.R;


/**
 * Activity shows application generated exception stack trace.
 */
public class ForceCloseActivity extends AppCompatActivity {

    private TextView mCrashReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_crash_viewer_activity);
        mCrashReport = (TextView) findViewById(R.id.tv_crash_report);
        String crashReport = getIntent().getStringExtra("crash_report");
        mCrashReport.setText(crashReport);
    }
}
