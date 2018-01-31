package com.example.arturmusayelyan.networking.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.arturmusayelyan.networking.models.ParentsCat;
import com.example.arturmusayelyan.networking.networking.CallModels;
import com.example.arturmusayelyan.networking.networking.WebServiceManager;
import com.example.arturmusayelyan.networking.utils.JsonParser;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by artur.musayelyan on 31/01/2018.
 */


//this example have not mxl
// adyunqe tpup enq miayn  LOG-erov
public class NetworkingBaseExamples extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        call1();
    }

    //get methodi orinak
    private void call1(){
        WebServiceManager.getCall(this,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                if(response!=null){
                    List<ParentsCat> list= JsonParser.parseJsonToParentsCatList(response);
                    JSONObject jsonObject=response.optJSONObject(0);
                    String name=jsonObject.optString("category_name");
                    Log.d("Art",name);
                }
            }
        });
    }

    // post methodi orinak
    private void call2(String email){
        StringEntity entity= CallModels.getResendVerificationCodeObject(email);
        WebServiceManager.postCall(this,"relativeUrl",entity,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
            }
        });
    }
}
