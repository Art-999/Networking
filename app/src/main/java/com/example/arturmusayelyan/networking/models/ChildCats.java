package com.example.arturmusayelyan.networking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artur.musayelyan on 29/01/2018.
 */

public class ChildCats {
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_count")
    @Expose
    private String categoryCount;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(String categoryCount) {
        this.categoryCount = categoryCount;
    }

    @Override
    public String toString() {
        return categoryId + " " + categoryName + " " + categoryCount;
    }
}
