package com.example.myclothingshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myclothingshop.ProductDetailsActivity;
import com.example.myclothingshop.R;

public class NewProductsFragment extends Fragment {

    private ImageView viewImg, viewImg1, viewImg2;
    private TextView viewName, viewDescription, viewPrice, viewRating;
    private TextView viewName1, viewDescription1, viewPrice1, viewRating1;
    private TextView viewName2, viewDescription2, viewPrice2, viewRating2;

    public NewProductsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_products, container, false);

        // Initialize views for the first product
        viewImg = view.findViewById(R.id.view_img);
        viewName = view.findViewById(R.id.view_name);
        viewDescription = view.findViewById(R.id.view_description);
        viewPrice = view.findViewById(R.id.view_price);
        viewRating = view.findViewById(R.id.view_rating);

        // Initialize views for the second product
        viewImg1 = view.findViewById(R.id.view_img1);
        viewName1 = view.findViewById(R.id.view_name1);
        viewDescription1 = view.findViewById(R.id.view_description1);
        viewPrice1 = view.findViewById(R.id.view_price1);
        viewRating1 = view.findViewById(R.id.view_rating1);

        // Initialize views for the third product
        viewImg2 = view.findViewById(R.id.view_img2);
        viewName2 = view.findViewById(R.id.view_name2);
        viewDescription2 = view.findViewById(R.id.view_description2);
        viewPrice2 = view.findViewById(R.id.view_price2);
        viewRating2 = view.findViewById(R.id.view_rating2);

        // Set up click listeners for each product image
        viewImg.setOnClickListener(v -> openProductDetails(R.drawable.fruits, "Shorts and Tshirt", "Comfortable Nightwear", "$30", "5.0"));
        viewImg1.setOnClickListener(v -> openProductDetails(R.drawable.eggss, "Green Shirt", "Casual Shirt", "$50", "5.0"));
        viewImg2.setOnClickListener(v -> openProductDetails(R.drawable.milk2, "Shorts", "Comfortable Shorts", "$50", "5.0"));

        return view;
    }

    private void openProductDetails(int imageRes, String name, String description, String price, String rating) {
        Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
        intent.putExtra("image_resource", imageRes);
        intent.putExtra("name", name);
        intent.putExtra("description", description);
        intent.putExtra("price", price);
        intent.putExtra("rating", rating);
        startActivity(intent);
    }
}
