package com.learning.myrestaurant;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryItem implements Parcelable {
    private String categoryName;
    private int categoryPhotoID;
    private String  item1, description1;
    private double price1;
    private int photoID1;
    private String  item2, description2;
    private double price2;
    private int photoID2;

    public CategoryItem(String categoryName, int categoryPhotoID, String item1, String description1, double price1, int photoID1, String item2, String description2, double price2, int photoID2) {
        this.categoryName = categoryName;
        this.categoryPhotoID = categoryPhotoID;
        this.item1 = item1;
        this.description1 = description1;
        this.price1 = price1;
        this.photoID1 = photoID1;
        this.item2 = item2;
        this.description2 = description2;
        this.price2 = price2;
        this.photoID2 = photoID2;
    }

    protected CategoryItem(Parcel in) {
        categoryName = in.readString();
        categoryPhotoID = in.readInt();
        item1 = in.readString();
        description1 = in.readString();
        price1 = in.readDouble();
        photoID1 = in.readInt();
        item2 = in.readString();
        description2 = in.readString();
        price2 = in.readDouble();
        photoID2 = in.readInt();
    }

    public static final Creator<CategoryItem> CREATOR = new Creator<CategoryItem>() {
        @Override
        public CategoryItem createFromParcel(Parcel in) {
            return new CategoryItem(in);
        }

        @Override
        public CategoryItem[] newArray(int size) {
            return new CategoryItem[size];
        }
    };

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryPhotoID() {
        return categoryPhotoID;
    }

    public String getItem1() {
        return item1;
    }

    public String getDescription1() {
        return description1;
    }

    public double getPrice1() {
        return price1;
    }

    public int getPhotoID1() {
        return photoID1;
    }

    public String getItem2() {
        return item2;
    }

    public String getDescription2() {
        return description2;
    }

    public double getPrice2() {
        return price2;
    }

    public int getPhotoID2() {
        return photoID2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoryName);
        dest.writeInt(categoryPhotoID);
        dest.writeString(item1);
        dest.writeString(description1);
        dest.writeDouble(price1);
        dest.writeInt(photoID1);
        dest.writeString(item2);
        dest.writeString(description2);
        dest.writeDouble(price2);
        dest.writeInt(photoID2);
    }
}
