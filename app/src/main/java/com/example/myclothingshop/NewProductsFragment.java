package com.example.myclothingshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class NewProductsFragment extends Fragment {

    private ImageView viewImg, viewImg1, viewImg2;

    public NewProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_products, container, false);

        // Initialize image views for the products
        viewImg = view.findViewById(R.id.view_img);
        viewImg1 = view.findViewById(R.id.view_img1);
        viewImg2 = view.findViewById(R.id.view_img2);

        // Set click listeners for each product image
        viewImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductDetailActivity("Product 1");
            }
        });

        viewImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductDetailActivity("Product 2");
            }
        });

        viewImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductDetailActivity("Product 3");
            }
        });

        return view;
    }

    // Method to open ProductDetailActivity and pass the product name
    private void openProductDetailActivity(String productName) {
        Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
        intent.putExtra("PRODUCT_NAME", productName);
        startActivity(intent);
    }
}
