package com.learning.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomCategoryItemAdapter extends ArrayAdapter<FoodItem> {


        public CustomCategoryItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<FoodItem> foodItems) {
        super(context, resource, foodItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_food_list, parent, false);
        }

        FoodItem categoryItemDisplay = getItem(position);
        TextView textView = convertView.findViewById(R.id.category_item_1);
        textView.setText(categoryItemDisplay.getName());
        return convertView;
    }



}
