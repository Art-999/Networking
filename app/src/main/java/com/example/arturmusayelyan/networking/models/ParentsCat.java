package com.example.arturmusayelyan.networking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artur.musayelyan on 29/01/2018.
 */

public class ParentsCat {
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_image")
    @Expose
    private String categoryImage;
    @SerializedName("category_count")
    @Expose
    private Integer categoryCount;
    @SerializedName("children_cats")
    @Expose
    private List<ChildCats> childrenCats = null;

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

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public Integer getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(Integer categoryCount) {
        this.categoryCount = categoryCount;
    }

    public List<ChildCats> getChildrenCats() {
        return childrenCats;
    }

    public void setChildrenCats(List<ChildCats> childrenCats) {
        this.childrenCats = childrenCats;
    }

    @Override
    public String toString() {
        return categoryId + " " + categoryName + " " + categoryCount + " categoryImage " + " childrenCatsList";
    }
}
