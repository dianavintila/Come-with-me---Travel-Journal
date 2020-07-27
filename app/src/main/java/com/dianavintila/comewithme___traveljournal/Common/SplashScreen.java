package com.dianavintila.comewithme___traveljournal.Common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD:app/src/main/java/com/dianavintila/comewithme___traveljournal/Common/SplashScreen.java
import com.dianavintila.comewithme___traveljournal.Trip.UserDashboard;
=======
import com.dianavintila.comewithme___traveljournal.User.UserDashboard;
>>>>>>> 7c8d2d99d9caaaac8bb2c703820930fb41f5baba:app/src/main/java/com/dianavintila/comewithme___cityguide/Common/SplashScreen.java
import com.dianavintila.comewithme___traveljournal.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMER=5000;
    // Variables
    ImageView backgroundImage;
    TextView developedByLine;
    //Animations
    Animation sideAnim;
    Animation bottomAnim;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Hooks
        backgroundImage=findViewById(R.id.background_image);
        developedByLine=findViewById(R.id.powerd_by_line);

        //Animations
        sideAnim=AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //set Animations on elements
        backgroundImage.setAnimation(sideAnim);
        developedByLine.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                onBoardingScreen=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime=onBoardingScreen.getBoolean("firstTime",true);
                if(isFirstTime){
                    SharedPreferences.Editor editor=onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();
                    Intent intent=new Intent(SplashScreen.this, OnBoarding.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Intent intent=new Intent(getApplicationContext(), UserDashboard.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, SPLASH_TIMER);
    }
}