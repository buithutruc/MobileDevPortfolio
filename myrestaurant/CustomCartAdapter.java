package com.learning.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomCartAdapter extends ArrayAdapter<OrderItem> {


    public CustomCartAdapter(@NonNull Context context, int resource, @NonNull ArrayList<OrderItem> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_cart, parent, false);
                }
        OrderItem orderItem = getItem(position);
        TextView name = convertView.findViewById(R.id.txv_name);
        name.setText(orderItem.getName());
        TextView quantity = convertView.findViewById(R.id.txv_quantity);
        quantity.setText(orderItem.getQuantity() + "");
        TextView price = convertView.findViewById(R.id.txv_price);
        price.setText(orderItem.getPrice() + "");
        TextView total = convertView.findViewById(R.id.txv_total);
        total.setText(orderItem.getTotal() + "");

        return convertView;
    }
}
