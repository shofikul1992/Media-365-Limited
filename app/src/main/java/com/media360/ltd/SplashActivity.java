package com.media360.ltd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private final Handler mHandler = new Handler();
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        }

        mContext = this;
        mHandler.postDelayed(mPendingLauncherRunnable, 3000);

    }

    private final Runnable mPendingLauncherRunnable = new Runnable() {
        @Override
        public void run() {

            goToNextActivity();

        }
    };


    public void goToNextActivity() {
        Intent mIntent = new Intent(mContext, HomeActivity.class);
        startActivity(mIntent);
        SplashActivity.this.finish();
    }


}
