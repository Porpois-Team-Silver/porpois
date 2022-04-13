package edu.odu.porpois.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.porpois.R;

public class ActivityLoadScreen extends AppCompatActivity {
    //Time in milliseconds to switch to MainActivity
    private static int TIME_OUT = 3800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_load_screen);

        final View myLayout = findViewById(R.id.imageView3);
        myLayout.animate().rotation(1080).alpha(1).setDuration(2300);

        new Handler().postDelayed(() ->

                myLayout.animate().alpha(0).setDuration(600)

        , 3000);

        new Handler().postDelayed(() -> {

                Intent i = new Intent(ActivityLoadScreen.this, ActivityCreateNickname.class);
                startActivity(i);
                finish();

        }, TIME_OUT);

    }

}