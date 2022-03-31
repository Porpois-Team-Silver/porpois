package com.example.porpois.taskPages;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import com.example.porpois.R;

public class Give extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give);

        // new colors for the top bars
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        assert actionBar != null;
        setActionBarColor(actionBar, "#6E9BD4");

        Window window = Give.this.getWindow();
        window.setStatusBarColor(Color.rgb(99, 136, 185));
    }

    private void setActionBarColor(ActionBar actionBar, String color) {
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor(color));

        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
    }
}