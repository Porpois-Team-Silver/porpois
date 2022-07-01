package edu.odu.porpois.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.porpois.R;

import java.util.Random;

import edu.odu.porpois.MainActivity;

public class ActivityProfile extends AppCompatActivity {

    //Create TextView variables for sharedPreferences
    TextView textView_nickName,textView_zipCode;
    Button button_clear, button_refresh_algorithm;
    SharedPreferences sharedPreferences;
    FrameLayout profileBtn;
    FrameLayout pointsBtn;
    TextView profileBtnText;
    TextView pointsBtnText;
    ConstraintLayout porPointsView;
    ConstraintLayout profileView;
    TextView porPoints;

    //Create TextView variables for sort algorithm
    TextView textView_total_likes, textView_connect_likes, textView_move_likes, textView_give_likes,
            textView_create_likes, textView_rejuvenate_likes ;

    //Create a shared preferences name and also create key names
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NICKNAME = "nickName";
    private static final String KEY_ZIPCODE = "zipCode";

    boolean algorithmData = true;

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set color of Activity Bar
        Window window = ActivityProfile.this.getWindow();
        window.setStatusBarColor(Color.rgb(99, 136, 185));

        //Remove Action Bar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        setContentView(R.layout.activity_profile);

        //assign variable values
        textView_nickName = findViewById(R.id.textViewNickName);
        textView_zipCode = findViewById(R.id.textViewZipCode);
        button_clear = findViewById(R.id.buttonClear);
        profileBtnText = findViewById(R.id.profileId);
        pointsBtnText = findViewById(R.id.pointId);
        profileBtn = findViewById(R.id.profileBtnId);
        pointsBtn = findViewById(R.id.pointsBtnId);
        porPointsView = findViewById(R.id.viewPorPointsId);
        profileView = findViewById(R.id.viewProfileId);
        porPoints = findViewById(R.id.porPointsId);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String nickName = sharedPreferences.getString(KEY_NICKNAME,null);
        String zipCode = sharedPreferences.getString(KEY_ZIPCODE,null);

        if (nickName != null || zipCode != null){
            //we set the data to TextView
            textView_nickName.setText(nickName);
            textView_zipCode.setText(zipCode);
        }

        //this button clears the user data and updates the text fields
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

        //This generates random numbers when the ActivityProfile loads up
        sortingAlgortihm();

        profileBtn.setOnClickListener(view -> {
            profileBtn.setBackgroundColor(getResources().getColor(R.color.buttonColor));
            profileBtnText.setTextColor(getResources().getColor(R.color.white));
            pointsBtn.setBackgroundColor(getResources().getColor(R.color.white));
            pointsBtnText.setTextColor(getResources().getColor(R.color.black));

            porPointsView.setVisibility(View.INVISIBLE);
            profileView.setVisibility(View.VISIBLE);
        });

        pointsBtn.setOnClickListener(view -> {
            pointsBtn.setBackgroundColor(getResources().getColor(R.color.buttonColor));
            pointsBtnText.setTextColor(getResources().getColor(R.color.white));
            profileBtn.setBackgroundColor(getResources().getColor(R.color.white));
            profileBtnText.setTextColor(getResources().getColor(R.color.black));

            porPoints.setText(MainActivity.porPoints + " PorPoints");

            profileView.setVisibility(View.INVISIBLE);
            porPointsView.setVisibility(View.VISIBLE);
        });
    }

    //create a function that generates random numbers between 0 - 100
    public static int random(int x) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(100);
    }

    @SuppressLint("SetTextI18n")
    public void sortingAlgortihm(){

        int connectLikes = 0, moveLikes = 0, giveLikes = 0, createLikes = 0, rejuvenateLikes = 0;

        connectLikes = random(connectLikes);
        textView_connect_likes = findViewById(R.id.textViewConnectProfile);

        moveLikes = random(moveLikes);
        textView_move_likes = findViewById(R.id.textViewMoveProfile);

        giveLikes = random(giveLikes);
        textView_give_likes = findViewById(R.id.textViewGiveProfile);

        createLikes = random(createLikes);
        textView_create_likes = findViewById(R.id.textViewCreateProfile);

        rejuvenateLikes = random(rejuvenateLikes);
        textView_rejuvenate_likes = findViewById(R.id.textViewRejuvenateProfile);

        int totalLikes = connectLikes + moveLikes + giveLikes + createLikes + rejuvenateLikes;
        textView_total_likes = findViewById(R.id.textViewTotalLikes);

        int connectLikesAvg = (connectLikes * 100) / totalLikes;
        int moveLikesAvg = (moveLikes * 100) / totalLikes;
        int giveLikesAvg = (giveLikes * 100) / totalLikes;
        int createLikesAvg = (createLikes * 100) / totalLikes;
        int rejuvenateLikesAvg = (rejuvenateLikes * 100) / totalLikes;

        int totalOfAvg = connectLikesAvg + moveLikesAvg + giveLikesAvg +createLikesAvg + rejuvenateLikesAvg;
        int maxOfNums = Math.max(connectLikesAvg, Math.max(moveLikesAvg, Math.max(giveLikesAvg, Math.max(createLikesAvg, rejuvenateLikesAvg))));
        int diff = 0;

        if (totalOfAvg < 100){
            diff = 100 - totalOfAvg;
        }

        if (maxOfNums == connectLikesAvg){
            connectLikesAvg = connectLikesAvg + diff;
        } else if (maxOfNums == moveLikesAvg){
            moveLikesAvg = moveLikesAvg + diff;
        } else if (maxOfNums == giveLikesAvg){
            giveLikesAvg = giveLikesAvg + diff;
        } else if (maxOfNums == createLikesAvg){
            createLikesAvg = createLikesAvg + diff;
        } else {
            rejuvenateLikesAvg = rejuvenateLikesAvg + diff;
        }

        int totalOfAvg2 = connectLikesAvg + moveLikesAvg + giveLikesAvg +createLikesAvg + rejuvenateLikesAvg;

        //String test = String.valueOf(maxOfNums);
        //Toast.makeText(ActivityProfile.this, test, Toast.LENGTH_LONG).show();


        textView_connect_likes.setText("Connect Likes = " + connectLikes + "         Avg. = " + connectLikesAvg);
        textView_move_likes.setText("Move Likes = " + moveLikes + "         Avg. = " + moveLikesAvg);
        textView_give_likes.setText("Give Likes = " + giveLikes + "         Avg. = " + giveLikesAvg);
        textView_create_likes.setText("Create Likes = " + createLikes + "         Avg. = " + createLikesAvg);
        textView_rejuvenate_likes.setText("Rejuvenate Likes = " + rejuvenateLikes + "         Avg. = " + rejuvenateLikesAvg);
        textView_total_likes.setText("Total Likes = " + totalLikes + "         Avg. Total = " + totalOfAvg2);


    }

    public void onClick(View view) {
        sortingAlgortihm();
    }

    public void onClick2(View view) {

        if(algorithmData) {

            algorithmData = false;
            View myLayout = findViewById(R.id.textViewTotalLikes);
            myLayout.animate().alpha(1);
            myLayout = findViewById(R.id.textViewConnectProfile);
            myLayout.animate().alpha(1);
            myLayout = findViewById(R.id.textViewMoveProfile);
            myLayout.animate().alpha(1);
            myLayout = findViewById(R.id.textViewGiveProfile);
            myLayout.animate().alpha(1);
            myLayout = findViewById(R.id.textViewCreateProfile);
            myLayout.animate().alpha(1);
            myLayout = findViewById(R.id.textViewRejuvenateProfile);
            myLayout.animate().alpha(1);
            myLayout = findViewById(R.id.imageViewPieChart);
            myLayout.animate().alpha(0);

        }
        else{

            algorithmData = true;
            View myLayout = findViewById(R.id.textViewTotalLikes);
            myLayout.animate().alpha(0);
            myLayout = findViewById(R.id.textViewConnectProfile);
            myLayout.animate().alpha(0);
            myLayout = findViewById(R.id.textViewMoveProfile);
            myLayout.animate().alpha(0);
            myLayout = findViewById(R.id.textViewGiveProfile);
            myLayout.animate().alpha(0);
            myLayout = findViewById(R.id.textViewCreateProfile);
            myLayout.animate().alpha(0);
            myLayout = findViewById(R.id.textViewRejuvenateProfile);
            myLayout.animate().alpha(0);
            myLayout = findViewById(R.id.imageViewPieChart);
            myLayout.animate().alpha(1);

        }

    }
}