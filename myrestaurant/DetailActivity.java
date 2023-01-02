package com.learning.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class DetailActivity extends AppCompatActivity {
    ImageView igv_photo;
    TextView txv_name, txv_description, txv_price;
    EditText txv_quantity;
    String name, description;
    int photoID;
    double price;
    int quantity = 0;
    Button btn_add;
    double subTotal;

    ArrayList<String> listOfNames = new ArrayList<>();
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txv_name = findViewById(R.id.item_name);
        txv_description = findViewById(R.id.item_description);
        txv_price = findViewById(R.id.price);
        igv_photo = findViewById(R.id.item_photo);
        txv_quantity = findViewById(R.id.quantity);
        btn_add = findViewById(R.id.btn_add);

        //Receive intent from FoodListActivity class
        Intent intent = getIntent();
        FoodItem foodItem = intent.getParcelableExtra("Food_Item_Position");
        name = foodItem.getName();
        description = foodItem.getDescription();
        price = foodItem.getPrice();
        photoID = foodItem.getPhotoID();


        //Populate values received from the intent
        txv_name.setText(name);
        txv_description.setText(description);
        txv_price.setText("$" + price);
        igv_photo.setImageResource(photoID);

        //When the Add button is clicked, if the item doesn't exist in the Order Database, add that item to the database
        //if it exits, update its quantity and subtotal
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (txv_quantity.getText() != null) {
                        quantity = Integer.parseInt(txv_quantity.getText() + "");
                        subTotal = Math.round(price * quantity * 100) / 100.0;
                        if (quantity == 0) {
                            Toast.makeText(getApplicationContext(), "Quantity is 0", Toast.LENGTH_SHORT).show();
                        }
                        if (quantity != 0) {
                            if (!isExisted()) {
                                addItem();
                            } else{
                                updateItem();
                            }
                            OrderDatabase.total = OrderDatabase.total + subTotal;
                            Toast.makeText(getApplicationContext(), quantity + " items are added.", Toast.LENGTH_SHORT).show();
                            Intent intent_BackToFoodListActivity = new Intent();
                            setResult(1, intent_BackToFoodListActivity);
                            finish();

                        }

                    }
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "Quantity is empty", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

        public void addItem () {
            OrderDatabase.orderItems.add(new OrderItem(name, quantity, price, subTotal));
        }

        public void updateItem(){
            int newQuantity = OrderDatabase.orderItems.get(index).getQuantity() + quantity;
            OrderDatabase.orderItems.get(index).setQuantity(newQuantity);
            double newSubTotal = Math.round(newQuantity * price * 100)/100.0;
            OrderDatabase.orderItems.get(index).setTotal(newSubTotal);
        }

        public boolean isExisted () {
            for (OrderItem items: OrderDatabase.orderItems) {
                listOfNames.add(items.getName());
            }
            index = listOfNames.indexOf(name);

            if (index >= 0) return true;
            else return false;
        }


}

