package com.learning.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomCategoryAdapter extends ArrayAdapter<CategoryItem> {
    public CustomCategoryAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CategoryItem> customCategories) {
        super(context, resource, customCategories);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View categoryItemView = convertView;
        if (categoryItemView == null){
            categoryItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent, false);
        }

        CategoryItem currentCategory = getItem(position);
        ImageView imageView = categoryItemView.findViewById(R.id.img);
        imageView.setImageResource(currentCategory.getCategoryPhotoID());
        TextView textView = categoryItemView.findViewById(R.id.category_name);
        textView.setText(currentCategory.getCategoryName());

        return categoryItemView;
    }
}
