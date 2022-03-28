package com.example.porpois;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.porpois.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up data binding on this activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        TextView hiddenText = binding.hiddenText;
        Button buttonReveal = binding.buttonReveal;

        // toggle text to test data binding
        buttonReveal.setOnClickListener(view -> {
            if(hiddenText.getVisibility() != View.VISIBLE) {
                hiddenText.setVisibility(View.VISIBLE);
            }
            else {
                hiddenText.setVisibility(View.INVISIBLE);
            }
        });
    }
}