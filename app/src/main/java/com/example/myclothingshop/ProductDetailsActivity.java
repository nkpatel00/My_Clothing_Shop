package com.example.myclothingshop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    ImageView view_img;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // Initialize the view
        view_img = findViewById(R.id.view_img);

        // Set the onClickListener for the image
        view_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call method to open the Product Details Activity with dynamic data
                openProductDetailActivity("Product 1", "Product 1 description", "29.99", R.drawable.eggss);
                // Example data, you can pass dynamic product data instead.
            }
        });
    }

    private void openProductDetailActivity(String productName, String productDescription, String productPrice, int productImage) {
        Intent intent = new Intent(ProductDetailsActivity.this, ProductDetailsActivity.class);
        intent.putExtra("PRODUCT_NAME", productName);
        intent.putExtra("PRODUCT_DESCRIPTION", productDescription);
        intent.putExtra("PRODUCT_PRICE", productPrice);
        intent.putExtra("PRODUCT_IMAGE", productImage);
        startActivity(intent);
    }
}
