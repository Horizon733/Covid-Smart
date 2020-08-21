package com.example.covidsmart.models;

public class Category {
    int mName;
    int mIconAddress;
    public Category(int name, int iconAddress){
        mName = name;
        mIconAddress = iconAddress;
    }

    public int getmName() {
        return mName;
    }

    public int getmIconAddress() {
        return mIconAddress;
    }
}
