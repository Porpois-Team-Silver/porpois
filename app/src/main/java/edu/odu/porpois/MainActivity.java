package edu.odu.porpois;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.porpois.R;

import edu.odu.porpois.ui.ActivityCreateNickname;
import edu.odu.porpois.ui.ActivityProfile;
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

        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(Color.rgb(99, 136, 185));
        setActionBarColor();

        setContentView(R.layout.activity_main);

        LinearLayout taskGallery = findViewById(R.id.taskGallery);
        LayoutInflater gInflator = LayoutInflater.from(this);

        for(int i = 1; i < 20; i++) {
            View view = gInflator.inflate(R.layout.task, taskGallery, false);
            ImageView scrollImg = view.findViewById(R.id.scrollImg);

            if(i % 3 == 0) {
                scrollImg.setImageResource(R.drawable.sample1);
            }
            else if (i % 2 == 0) {
                scrollImg.setImageResource(R.drawable.sample2);
            }
            else {
                scrollImg.setImageResource(R.drawable.sample3);
            }

            taskGallery.addView(view);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.porpois_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Intent intent = new Intent(MainActivity.this, ActivityProfile.class);
                startActivity(intent);
                return true;
            case R.id.item1:
                Toast.makeText(this, "Connect Button Presses", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Move Button Pressed", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Give Button Pressed", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(this, "Create Button Pressed", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item5:
                Toast.makeText(this, "Rejuvenate Button Pressed", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Change the action bar color to a light blue
    private void setActionBarColor(){
        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#6E98D4"));
        // Set BackgroundDrawable
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);

    }

}
