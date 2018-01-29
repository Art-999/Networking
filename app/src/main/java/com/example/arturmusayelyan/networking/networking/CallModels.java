package com.example.arturmusayelyan.networking.networking;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by artur.musayelyan on 29/01/2018.
 */

public class CallModels {
    //Orinak bookie-ic
    public static StringEntity getLogInObject(String userName, String password) {
/**
 * log in json example
 *{
 *  "command": "signIn",
 *      "params":{
 *          "userName":"armine",
 *           "password":"123456"
 *       }
 * }
 * */
        final JSONObject body = new JSONObject();
        try {
            body.put("command", "signIn");
            JSONObject params = new JSONObject();
            params.put("userName", userName);
            params.put("password", password);
            body.put("params", params);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StringEntity entity = null;
        try {
            entity = new StringEntity(body.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("Sign in Body " + body);
        return entity;
    }
}
