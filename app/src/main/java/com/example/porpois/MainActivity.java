package com.example.porpois;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.porpois.databinding.ActivityMainBinding;
import com.example.porpois.taskPages.Connect;
import com.example.porpois.taskPages.Give;
import com.example.porpois.taskPages.Go;
import com.example.porpois.taskPages.Help;
import com.example.porpois.taskPages.Make;
import com.example.porpois.taskPages.Try;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up data binding on this activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //new colors for the top bars
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        assert actionBar != null;
        setActionBarColor(actionBar, "#6E9BD4");


        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(Color.rgb(99, 136, 185));


        // connect button behaviors
        Button connectButton = binding.connectButton;
        connectButton.setOnClickListener(view -> {
            Intent connectIntent = new Intent(MainActivity.this, Connect.class);
            startActivity(connectIntent);
        });

        // give button behaviors
        Button giveButton = binding.buttonGive;
        giveButton.setOnClickListener(view -> {
            Intent giveIntent = new Intent(MainActivity.this, Give.class);
            startActivity(giveIntent);
        });

        // go button behaviors
        Button goButton = binding.goButton;
        goButton.setOnClickListener(view -> {
            Intent goIntent = new Intent(MainActivity.this, Go.class);
            startActivity(goIntent);
        });

        // make button behaviors
        Button makeButton = binding.makeButton;
        makeButton.setOnClickListener(view -> {
            Intent makeIntent = new Intent(MainActivity.this, Make.class);
            startActivity(makeIntent);
        });

        // try button behaviors
        Button tryButton = binding.tryButton;
        tryButton.setOnClickListener(view -> {
            Intent tryIntent = new Intent(MainActivity.this, Try.class);
            startActivity(tryIntent);
        });

        // give button behaviors
        Button helpButton = binding.helpButton;
        helpButton.setOnClickListener(view -> {
            Intent helpIntent = new Intent(MainActivity.this, Help.class);
            startActivity(helpIntent);
        });


    }

    private void setActionBarColor(ActionBar actionBar, String color) {
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor(color));

        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
    }


}
