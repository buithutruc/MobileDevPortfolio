package com.learning.myrestaurant;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodItem implements Parcelable{

    private String name, description;
    private double price;
    private int photoID;


    public FoodItem(String name, String description, double price, int photoID) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.photoID = photoID;
    }

    protected FoodItem(Parcel in) {
        name = in.readString();
        description = in.readString();
        price = in.readDouble();
        photoID = in.readInt();
    }

    public static final Creator<FoodItem> CREATOR = new Creator<FoodItem>() {
        @Override
        public FoodItem createFromParcel(Parcel in) {
            return new FoodItem(in);
        }

        @Override
        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getPhotoID() {
        return photoID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeDouble(price);
        dest.writeInt(photoID);
    }
}
