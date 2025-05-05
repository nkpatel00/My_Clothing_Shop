package com.example.myclothingshop.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myclothingshop.R;
import com.example.myclothingshop.adepter.ViewAllAdepter;
import com.example.myclothingshop.models.ViewAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    FirebaseFirestore firestore;
    List<ViewAllModel> viewAllModelsList;
    ViewAllAdepter viewAllAdapter;
    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all2);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.view_all_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewAllModelsList = new ArrayList<>();
        viewAllAdapter = new ViewAllAdepter(this, viewAllModelsList);
        recyclerView.setAdapter(viewAllAdapter);

        String type = getIntent().getStringExtra("type");

        if (type != null) {
            fetchProductsByType(type);
        } else {
            Log.w("ViewAllActivity", "No product type received from intent");
        }
    }

    private void fetchProductsByType(String type) {
        Log.d("DEBUG", "Type received: " + type);

        firestore.collection("AllProducts")
                .whereEqualTo("type", type.toLowerCase())
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<DocumentSnapshot> docs = task.getResult().getDocuments();
                        Log.d("DEBUG", "Documents size: " + docs.size());

                        for (DocumentSnapshot doc : docs) {
                            Log.d("DEBUG", "Document data: " + doc.getData());
                        }
                    } else {
                        Log.e("DEBUG", "Firestore error: ", task.getException());
                    }
                });

        firestore.collection("AllProducts")
                .whereEqualTo("type", type.toLowerCase())
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        List<DocumentSnapshot> docs = task.getResult().getDocuments();
                        Log.d("FIREBASE", "Documents found: " + docs.size());

                        viewAllModelsList.clear(); // clear old items if any
                        for (DocumentSnapshot doc : docs) {
                            ViewAllModel model = doc.toObject(ViewAllModel.class);
                            if (model != null) {
                                viewAllModelsList.add(model);
                            }
                        }
                        viewAllAdapter.notifyDataSetChanged();
                    } else {
                        Log.e("FIREBASE", "Error fetching data: ", task.getException());
                    }
                });
    }
}
