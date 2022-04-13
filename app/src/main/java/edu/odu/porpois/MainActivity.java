package edu.odu.porpois;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.databinding.DataBindingUtil;

import com.example.porpois.R;
//import com.example.porpois.databinding.ActivityMainBinding;
import edu.odu.porpois.ui.Connect;
import edu.odu.porpois.ui.Give;
import edu.odu.porpois.ui.Go;
import edu.odu.porpois.ui.Help;
import edu.odu.porpois.ui.Make;
import edu.odu.porpois.ui.Try;

public class MainActivity extends AppCompatActivity {
//    private ActivityMainBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
            This removes the action bar (top banner that said "porpois").
            I think it looks cleaner without it when it comes out of the load
            screen but this is something we can discuss later
        */
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(Color.rgb(99, 136, 185));

        setContentView(R.layout.activity_main);

        // set up data binding on this activity
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);



        String nickname = getIntent().getStringExtra("nickname").trim();
        TextView greeting = findViewById(R.id.mainActivityGreeting);
        greeting.setText(String.format("Good Afternoon, %s", nickname));



        // connect button behaviors
        Button connectButton = findViewById(R.id.connectButton);
        connectButton.setOnClickListener(view -> {
            Intent connectIntent = new Intent(MainActivity.this, Connect.class);
            startActivity(connectIntent);
        });

        // give button behaviors
        Button giveButton = findViewById(R.id.buttonGive);
        giveButton.setOnClickListener(view -> {
            Intent giveIntent = new Intent(MainActivity.this, Give.class);
            startActivity(giveIntent);
        });

        // go button behaviors
        Button goButton = findViewById(R.id.goButton);
        goButton.setOnClickListener(view -> {
            Intent goIntent = new Intent(MainActivity.this, Go.class);
            startActivity(goIntent);
        });

        // make button behaviors
        Button makeButton = findViewById(R.id.makeButton);
        makeButton.setOnClickListener(view -> {
            Intent makeIntent = new Intent(MainActivity.this, Make.class);
            startActivity(makeIntent);
        });

        // try button behaviors
        Button tryButton = findViewById(R.id.tryButton);
        tryButton.setOnClickListener(view -> {
            Intent tryIntent = new Intent(MainActivity.this, Try.class);
            startActivity(tryIntent);
        });

        // give button behaviors
        Button helpButton = findViewById(R.id.helpButton);
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
