package edu.odu.porpois;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.porpois.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import edu.odu.porpois.model.TaskActivity;
import edu.odu.porpois.ui.ActivityCreateNickname;
import edu.odu.porpois.ui.ActivityProfile;
import io.grpc.internal.JsonParser;


public class MainActivity extends AppCompatActivity {
    //    private ActivityMainBinding binding;
    private final String TAG = "MAIN";

    private LayoutInflater gInflator;
    private LinearLayout taskGallery;

    public ArrayList<String> completedActivities = new ArrayList<>();
    public static int porPoints = 0;
    private static final String KEY_COMPLETED_ACTIVITIES = "completedActivities";
    private static final String KEY_POR_POINTS = "porPoints";
    SharedPreferences sharedPreferences;

    //Create a shared preferences name and also create key names
    private static final String SHARED_PREF_NAME = "mypref";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(Color.rgb(99, 136, 185));
        setActionBarColor();
        setTitle("Porpois");
        getActionBar();

        setContentView(R.layout.activity_main);

        taskGallery = findViewById(R.id.taskGallery);
        gInflator = LayoutInflater.from(this);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String activities = sharedPreferences.getString(KEY_COMPLETED_ACTIVITIES,null);
        porPoints = sharedPreferences.getInt(KEY_POR_POINTS,0);

        if(activities != null) {
            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(activities);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int i = 0; i< Objects.requireNonNull(jsonArray).length(); i++) {
                try {
                    completedActivities.add(jsonArray.getString(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Log.d(TAG, "completedActivities: " + completedActivities);
        }

        getActivities(0);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.porpois_menu, menu);
        return true;
    }

    // Disables the back button
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
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
                Toast.makeText(this, "Connect Category Selected", Toast.LENGTH_SHORT).show();
                getActivities(1);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Move Category Selected", Toast.LENGTH_SHORT).show();
                getActivities(2);
                return true;
            case R.id.item3:
                Toast.makeText(this, "Give Category Selected", Toast.LENGTH_SHORT).show();
                getActivities(3);
                return true;
            case R.id.item4:
                Toast.makeText(this, "Create Category Selected", Toast.LENGTH_SHORT).show();
                getActivities(4);
                return true;
            case R.id.item5:
                Toast.makeText(this, "Rejuvenate Category Selected", Toast.LENGTH_SHORT).show();
                getActivities(5);
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

    @SuppressLint("SetTextI18n")
    public void getActivities(int categoryNumber) {
        taskGallery.removeAllViews();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference activitiesRef = db.collection("activities");
        Query query;

        if (categoryNumber != 0)
            query = activitiesRef.whereEqualTo(TaskActivity.CATEGORY, categoryNumber).limit(20);
        else
            query = activitiesRef.limit(20);


        query.get().addOnSuccessListener(queryDocumentSnapshots -> {

            for (QueryDocumentSnapshot snapshot : queryDocumentSnapshots)
            {
                String encodedImage = Objects.requireNonNull(snapshot.get("image")).toString();
                byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
                Bitmap bmp = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                View view = gInflator.inflate(R.layout.task, taskGallery, false);
                ImageView likes = view.findViewById(R.id.likeImg);
//                    TextView counterText = view.findViewById(R.id.counterId);
                likes.setImageResource(R.drawable.like);
                likes.setOnClickListener(inView -> Toast.makeText(
                        MainActivity.this,
                        R.string.likeClicked,
                        Toast.LENGTH_LONG
                ).show());
                ImageView dislikes = view.findViewById(R.id.dislikeImg);
                dislikes.setImageResource(R.drawable.dislike);
                dislikes.setOnClickListener(inView -> Toast.makeText(
                        MainActivity.this,
                        R.string.dislikeClicked,
                        Toast.LENGTH_LONG
                ).show());
                ImageView scrollImg = view.findViewById(R.id.scrollImg);
                scrollImg.setImageBitmap(bmp);
                taskGallery.addView(view);


                TaskActivity taskActivity = new TaskActivity(snapshot);
                String id = snapshot.getId();
                CheckBox completeTask = view.findViewById(R.id.completeTaskId);

                if(completedActivities.contains(id)) {
                    completeTask.setText("Completed");
                    completeTask.setChecked(true);
                } else {
                    completeTask.setText("Complete");
                }

                completeTask.setOnClickListener(view1 -> {


                    if(completeTask.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        completedActivities.add(id);
                        porPoints += taskActivity.getPointValue();
                        JSONArray jsonArray = new JSONArray(completedActivities);
                        Log.d(TAG, "saving : " + jsonArray + " porPoints: " + porPoints);
                        editor.putString(KEY_COMPLETED_ACTIVITIES, jsonArray.toString());
                        editor.putInt(KEY_POR_POINTS, porPoints);
                        editor.apply();
                        Toast.makeText(
                                MainActivity.this,
                                "\uD83E\uDD17 Great! Activity task Completed +" + taskActivity.getPointValue() + " PorPoints",
                                Toast.LENGTH_LONG
                        ).show();
                    }

                    completeTask.setText("Completed");

                    completeTask.setChecked(true);
                });


//                    activityList.add(taskActivity);
                Log.d(TAG, "taskActivity: " + taskActivity);
            }
        });
    }

    public static boolean isVisible(final View view, int height, int width) {
        if (view == null) {
            return false;
        }
        if (!view.isShown()) {
            return false;
        }
        final Rect actualPosition = new Rect();
        view.getGlobalVisibleRect(actualPosition);
        final Rect screen = new Rect(0, 0, width, height);
        return actualPosition.intersect(screen);
    }


}
