package edu.odu.porpois.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.porpois.R;

public class ActivityProfile extends AppCompatActivity {

    //Create variables for sharedPreferences
    TextView textView_nickName,textView_zipCode;
    Button button_clear;
    SharedPreferences sharedPreferences;

    //Create a shared preferences name and also create key names
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NICKNAME = "nickName";
    private static final String KEY_ZIPCODE = "zipCode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = ActivityProfile.this.getWindow();
        window.setStatusBarColor(Color.rgb(99, 136, 185));

        //Remove action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        setContentView(R.layout.activity_profile);

        //Give the objects values
        textView_nickName = findViewById(R.id.textViewNickName);
        textView_zipCode = findViewById(R.id.textViewZipCode);
        button_clear = findViewById(R.id.buttonClear);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String nickName = sharedPreferences.getString(KEY_NICKNAME,null);
        String zipCode = sharedPreferences.getString(KEY_ZIPCODE,null);

        if (nickName != null || zipCode != null){
            //we set the data to TextView
            textView_nickName.setText(nickName);
            textView_zipCode.setText(zipCode);

        }

        //now we call to button for logout

        button_clear.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            String nickName1 = sharedPreferences.getString(KEY_NICKNAME,null);
            String zipCode1 = sharedPreferences.getString(KEY_ZIPCODE,null);
            textView_nickName.setText(nickName1);
            textView_zipCode.setText(zipCode1);
            Toast.makeText(ActivityProfile.this, "User Data Cleared", Toast.LENGTH_LONG).show();
        });
    }

}