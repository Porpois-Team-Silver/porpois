package edu.odu.porpois.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.porpois.R;

import edu.odu.porpois.MainActivity;

public class ActivityCreateNickname extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        setContentView(R.layout.activity_create_nickname);

        Window window = ActivityCreateNickname.this.getWindow();
        window.setStatusBarColor(Color.rgb(99, 136, 185));
    }

    public void onClickToMainActivity(View view){
        Intent intent = new Intent(ActivityCreateNickname.this, MainActivity.class);
        EditText editTextNickname = findViewById(R.id.editTextNickname);
        intent.putExtra("nickname", editTextNickname.getText().toString().trim());

        startActivity(intent);
    }
}