package edu.odu.porpois.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.porpois.R;

public class ActivityLoadScreen extends AppCompatActivity {
    //Time in milliseconds to switch to MainActivity
    private static int TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_load_screen);

        View myLayout = findViewById(R.id.imageViewLoadScreen1);
        myLayout.animate().setDuration(4000);

        new Handler().postDelayed(() -> myLayout.animate().alpha(0).setDuration(1000), 2500);


        new Handler().postDelayed(() -> {

                Intent i = new Intent(ActivityLoadScreen.this, ActivityCreateNickname.class);
                startActivity(i);
                finish();

        }, TIME_OUT);

    }

}