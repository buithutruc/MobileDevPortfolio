package com.learning.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    TextView txv_cartTotal;
    Button btn_clear;
    CustomCartAdapter customCartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        ListView cart_listview = findViewById(R.id.cart_listview);
        customCartAdapter = new CustomCartAdapter(this, 0, OrderDatabase.orderItems );
        cart_listview.setAdapter(customCartAdapter);

        txv_cartTotal = findViewById(R.id.cart_total);
        txv_cartTotal.setText(Math.round(OrderDatabase.total *100)/100.0 + "");


        btn_clear = findViewById(R.id.clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  OrderDatabase.orderItems.clear();
                  OrderDatabase.total = 0;
                  cart_listview.setAdapter(null);
                  txv_cartTotal.setText("0.0");
                  Intent intent_backToFoodListActivity = new Intent();
                  setResult(1, intent_backToFoodListActivity);
            }
        });
    }

}