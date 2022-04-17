package edu.odu.porpois.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.porpois.R;

import edu.odu.porpois.MainActivity;

public class ActivityCreateNickname extends AppCompatActivity {
    //Create variables for sharedPreferences
    EditText editText_nickName,editText_zipCode;
    Button button_create;
    SharedPreferences sharedPreferences;

    //Create a shared preferences name and also create key names
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NICKNAME = "nickName";
    private static final String KEY_ZIPCODE = "zipCode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove action bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        //Change color of the status bar
        Window window = ActivityCreateNickname.this.getWindow();
        window.setStatusBarColor(Color.rgb(99, 136, 185));

        //Lock in activity display settings
        setContentView(R.layout.activity_create_nickname);

        //assign values to variables
        editText_nickName = findViewById(R.id.editTextNicknameFinal);
        editText_zipCode = findViewById(R.id.editTextZipcodeFinal);
        button_create = findViewById(R.id.buttonNickname);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        //Check to see if KEY_NICKNAME and KEY_ZIPCODE already have stored values
        String name = sharedPreferences.getString(KEY_NICKNAME,null);
        String zip = sharedPreferences.getString(KEY_ZIPCODE,null);
        if (name != null && zip != null){
            //if data is available then directly go to HomeActivity
            Intent intent = new Intent(ActivityCreateNickname.this,MainActivity.class);
            startActivity(intent);
        }

        //We can open next activity using calling listener on Button
        button_create.setOnClickListener(view -> {
            // when we click the button save the data to shared preferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_NICKNAME,editText_nickName.getText().toString());
            editor.putString(KEY_ZIPCODE,editText_zipCode.getText().toString());
            editor.apply();

            Intent intent = new Intent(ActivityCreateNickname.this,MainActivity.class);
            startActivity(intent);

            Toast.makeText(ActivityCreateNickname.this, "Preferences Saved", Toast.LENGTH_LONG).show();
        });

    }

    /*
    //Create action when the create button is clicked
    public void onClickToMainActivity(View view){
        Intent intent = new Intent(ActivityCreateNickname.this, MainActivity.class);
        Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

     */
}