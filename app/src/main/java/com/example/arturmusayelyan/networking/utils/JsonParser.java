package com.example.arturmusayelyan.networking.utils;

import com.example.arturmusayelyan.networking.models.ChildCats;
import com.example.arturmusayelyan.networking.models.ParentsCat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by artur.musayelyan on 29/01/2018.
 */

public class JsonParser {
    public static List<ParentsCat> parseJsonToParentsCatList(JSONArray jsonArray) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<ParentsCat>>() {
        }.getType();
        List<ParentsCat> parentsCatList = gson.fromJson(String.valueOf(jsonArray), type);

        return parentsCatList;
    }

    public static ParentsCat parseToParentsCatObject(JSONObject jsonObject) {
        Gson gson = new Gson();
        ParentsCat parentsCat = gson.fromJson(String.valueOf(jsonObject), ParentsCat.class);
        return parentsCat;
    }
    public static List<ChildCats> parseJsonToChildCatsList(JSONArray jsonArray){
        Gson gson=new Gson();
        Type type=new TypeToken<List<ChildCats>>(){}.getType();
        List<ChildCats> childCatsList=gson.fromJson(String.valueOf(jsonArray),type);
        return childCatsList;
    }
}
