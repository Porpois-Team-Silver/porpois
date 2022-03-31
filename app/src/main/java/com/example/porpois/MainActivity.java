package com.example.porpois;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.porpois.databinding.ActivityMainBinding;
import com.example.porpois.taskPages.Connect;
import com.example.porpois.taskPages.Give;
import com.example.porpois.taskPages.Go;
import com.example.porpois.taskPages.Make;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up data binding on this activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

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

        // give button behaviors
        Button makeButton = binding.makeButton;
        makeButton.setOnClickListener(view -> {
            Intent makeIntent = new Intent(MainActivity.this, Make.class);
            startActivity(makeIntent);
        });
//
//        // give button behaviors
//        Button giveButton = binding.buttonGive;
//        giveButton.setOnClickListener(view -> {
//            Intent giveIntent = new Intent(MainActivity.this, Give.class);
//            startActivity(giveIntent);
//        });
//
//        // give button behaviors
//        Button giveButton = binding.buttonGive;
//        giveButton.setOnClickListener(view -> {
//            Intent giveIntent = new Intent(MainActivity.this, Give.class);
//            startActivity(giveIntent);
//        });



    }
}