package com.example.porpois.taskPages;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.porpois.R;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //remove action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        setContentView(R.layout.activity_help);

        Window window = Help.this.getWindow();
        window.setStatusBarColor(Color.rgb(99, 136, 185));
    }

    private void setActionBarColor(ActionBar actionBar, String color) {
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor(color));

        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
    }
}