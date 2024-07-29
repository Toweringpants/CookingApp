package com.example.cookingapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories")
public class Category {
    @PrimaryKey(autoGenerate = true)
    private long mId;
    private String mText;
    private long mUpdateTime;

    public Category(@NonNull String text, @NonNull long id) {
        mText = text;
        mId = id;
        mUpdateTime = System.currentTimeMillis();
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getText() {
        return mText;
    }

    public void setText(String category) {
        mText = category;
    }

    public long getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(long updateTime) {
        mUpdateTime = updateTime;
    }
}
