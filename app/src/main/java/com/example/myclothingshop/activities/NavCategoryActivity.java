package com.example.myclothingshop.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myclothingshop.R;
import com.example.myclothingshop.adepter.NavCategoryDetailedAdepter;
import com.example.myclothingshop.models.NavCategoryDetailedModel;
import com.example.myclothingshop.models.RecommendedModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class NavCategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<NavCategoryDetailedModel> list;
    NavCategoryDetailedAdepter adepter;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_category);

        db = FirebaseFirestore.getInstance();
        recyclerView.findViewById(R.id.nav_cat_det_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adepter = new NavCategoryDetailedAdepter(this,list);
        recyclerView.setAdapter(adepter);

        db.collection("NavCategoryDetailed")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()) {
                            for(QueryDocumentSnapshot document : task.getResult()){

                                NavCategoryDetailedModel navCategoryDetailedModel = document.toObject(NavCategoryDetailedModel.class);
                                list.add(navCategoryDetailedModel);
                                adepter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(NavCategoryActivity.this,"Error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

        };
    }
