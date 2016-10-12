package com.asmobisoft.coffer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.asmobisoft.coffer.commonmethod.Utility;
import com.asmobisoft.coffer.registration.LoginActivity;

/**
 * Created by root on 2/1/16.
 */

public class SplashActivity extends Activity {

    // Splash screen timer
    private static int SLEEP_TIME = 3;//Splash timing in sec
    private IntentLauncher launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        launcher = new IntentLauncher();
        launcher.start();

    }
    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity1
        moveTaskToBack(true);
       // overridePendingTransition(R.anim.slidout,R.anim.slidin);

    }


    private class IntentLauncher extends Thread {

        public void run() {
            try {
                Thread.sleep(SLEEP_TIME * 1000);
            } catch (Exception e) {
                // TODO: handle exception
            }

            String strmobile = Utility.getPrefsData(SplashActivity.this,"mobile","");
            Log.e("Splash Activity","strmobile vlaue : "+strmobile);
            if(strmobile.length() > 0){
                Intent i = new Intent(SplashActivity.this, MainActivity1.class);
                startActivity(i);
                // close this activity
                finish();
            }else{
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }


            //Animator Part going here
           // overridePendingTransition(R.anim.slidin,R.anim.slidout);
        }
    }



        }
