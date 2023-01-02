package com.learning.myrestaurant;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {
    TextView totalAmount;
    Button cart_button;
    ArrayList<FoodItem> foodItems;

    //Send an intent for total amount result to DetailActivity class
    ActivityResultLauncher<Intent> launcher_DetailActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    totalAmount = findViewById(R.id.total_amount);
                    totalAmount.setText(Math.round(OrderDatabase.total *100)/100.0 + "");
                }

    });

    //Send an intent for total amount result to CartActivity class
    ActivityResultLauncher<Intent> launcher_CartActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    totalAmount = findViewById(R.id.total_amount);
                    totalAmount.setText(Math.round(OrderDatabase.total *100)/100.0 + "");
                }

            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        //set value for the total amount text view when the app is created
        totalAmount = findViewById(R.id.total_amount);
        totalAmount.setText(Math.round(OrderDatabase.total *100)/100.0 + "");

        //Receive intent from Main Activity
        Intent intent = getIntent();
        if (intent != null && intent.getParcelableExtra("Category_Item") != null){
            CategoryItem categoryItem = intent.getParcelableExtra("Category_Item");
            Log.d("Inside FoodListActivity Class", categoryItem.toString());
            foodItems = new ArrayList<>();
            String item1 = categoryItem.getItem1();
            String item2 = categoryItem.getItem2();
            String description1 = categoryItem.getDescription1();
            String description2 = categoryItem.getDescription2();
            double price1 = categoryItem.getPrice1();
            double price2 = categoryItem.getPrice2();
            int photoID1 = categoryItem.getPhotoID1();
            int photoID2 = categoryItem.getPhotoID2();
            foodItems.add(new FoodItem(item1, description1, price1, photoID1));
            foodItems.add(new FoodItem(item2, description2, price2, photoID2));
        }


        //Create food item objects to display in the Listview and pass over DetailActivity class
        ListView foodList_listview = findViewById(R.id.foodList_listview);
        CustomCategoryItemAdapter customCategoryItemAdapter = new CustomCategoryItemAdapter(this, 0, foodItems);
        foodList_listview.setAdapter(customCategoryItemAdapter);
        //End the process


        //When a Listview item is clicked, it sends the selected item to DetailActivity class
        foodList_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FoodListActivity.this, DetailActivity.class);
                intent.putExtra("Food_Item_Position", foodItems.get(position));
                launcher_DetailActivity.launch(intent);
            }
        });

        //When the cart button is clicked, it opens the Cart Activity activity
        cart_button = findViewById(R.id.see_cart);
        cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodListActivity.this, CartActivity.class);
                launcher_CartActivity.launch(intent);
            }
        });

    }

}


