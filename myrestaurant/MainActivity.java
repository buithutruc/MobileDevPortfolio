package com.learning.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Student Name: Thi Thu Truc Bui
    //Student Number: 261072531
    //This is the second submission

    private ArrayList<CategoryItem> mCategoryItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCategoryItem();
        launchFoodListActivity();
    }
    public void createCategoryItem(){
        mCategoryItem = new ArrayList<>();
        mCategoryItem.add(new CategoryItem("Pho",R.drawable.a_pho,"Beef Pho Special","Rare beef, well-done, tripe, beef balls & tendon", 14.99, R.drawable.pho_special, "Vegetarian Pho","Mushroom, broccoli, carrot, cauliflower, tofu", 12.99, R.drawable.pho_vegetarian));
        mCategoryItem.add(new CategoryItem("Vermicelli", R.drawable.b_vermicelli, "Grilled Beef Vermicelli","Grilled beef and chicken spring roll", 14.99, R.drawable.vermicelli_beef, "Vegan Vermicelli", "Grilled king oyster mushroom, tofu", 12.99, R.drawable.vermicelli_vegan));
        mCategoryItem.add(new CategoryItem("Rice", R.drawable.c_rice, "Broken Rice Special","Pork chop, shredded pork skin, meatloaf and eggs", 14.99, R.drawable.broken_rice, "Veggie Fried-Rice", "Mushroom, broccoli, carrot, edamame", 12.99, R.drawable.fried_rice));
        mCategoryItem.add(new CategoryItem("Dessert", R.drawable.d_dessert, "Banana Coconut Dessert", "Banana, tapioca pearls, coconut sauce", 5.99, R.drawable.banana_coconut, "Fruit Cocktail", "Vietnamese fruits, coconut sauce", 5.99, R.drawable.fruit_cocktail));
    }

    public void launchFoodListActivity(){
        ListView main_listview = findViewById(R.id.main_listview);
        CustomCategoryAdapter customCategoryAdapter = new CustomCategoryAdapter(this, 0, mCategoryItem);
        main_listview.setAdapter(customCategoryAdapter);
        main_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                intent.putExtra("Category_Item", mCategoryItem.get(position));
                startActivity(intent);
            }
        });

    }

}