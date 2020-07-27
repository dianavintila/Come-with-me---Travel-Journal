package com.dianavintila.comewithme___traveljournal.Common;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.dianavintila.comewithme___traveljournal.HelperClases.SliderAdapter;
import com.dianavintila.comewithme___traveljournal.R;
<<<<<<< HEAD:app/src/main/java/com/dianavintila/comewithme___traveljournal/Common/OnBoarding.java
import com.dianavintila.comewithme___traveljournal.Trip.UserDashboard;
=======
import com.dianavintila.comewithme___traveljournal.User.UserDashboard;
>>>>>>> 7c8d2d99d9caaaac8bb2c703820930fb41f5baba:app/src/main/java/com/dianavintila/comewithme___cityguide/Common/OnBoarding.java

public class OnBoarding extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsGetStarted;
    Animation animation;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

    //HOOKS
    viewPager=findViewById(R.id.slider);
    dotsLayout=findViewById(R.id.dots);
    letsGetStarted=findViewById(R.id.get_started_btn );

    //Call adapter
        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }
    public void skip(View view){
        startActivity(new Intent(this,UserDashboard.class));
        finish();
    }

    public void next(View view){
        viewPager.setCurrentItem(currentPosition+1);
    }

    private void addDots(int position){
        dots=new TextView[4];
        dotsLayout.removeAllViews();

        for(int i=0; i<dots.length;i++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }


    }

    ViewPager.OnPageChangeListener changeListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        addDots(position);
        currentPosition=position;
        if(position==0)
        {
            letsGetStarted.setVisibility(View.INVISIBLE);

        }
        else if(position==1){
            letsGetStarted.setVisibility(View.INVISIBLE);

        }
        else if(position==2){
            letsGetStarted.setVisibility(View.INVISIBLE);

        }
        else{
            animation=AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
            letsGetStarted.setAnimation(animation);
            letsGetStarted.setVisibility(View.VISIBLE);

        }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}