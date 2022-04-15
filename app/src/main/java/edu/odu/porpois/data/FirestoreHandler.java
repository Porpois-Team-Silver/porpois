package edu.odu.porpois.data;

import static java.lang.Integer.parseInt;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import edu.odu.porpois.model.TaskActivity;


public class FirestoreHandler {

    private final String TAG = "FirestoreHandler";
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference activitiesRef = db.collection("activities");


    public void getActivities(int categoryNumber) {

        Query query;

        if (categoryNumber != 0)
            query = activitiesRef.whereEqualTo(TaskActivity.CATEGORY, categoryNumber);
        else
            query = activitiesRef;

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                                TaskActivity taskActivity = new TaskActivity(document);
                                Log.d(TAG, taskActivity.toString());
                            }
                        }
                        else
                        {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
