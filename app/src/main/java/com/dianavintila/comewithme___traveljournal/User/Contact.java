package com.dianavintila.comewithme___traveljournal.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dianavintila.comewithme___traveljournal.R;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Button btninsta = findViewById(R.id.button_insta);

        btninsta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.instagram.com/dianavintilaa/?hl=ro"));
                startActivity(myWebLink);
            }
        });
        Button btnfb= findViewById(R.id.button_fb);

        btnfb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.facebook.com/profile.php?id=100004322537662"));
                startActivity(myWebLink);
            }
        });
    }
}