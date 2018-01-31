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

    public static StringEntity getResendVerificationCodeObject(String email) {
        /**
         * log in json example
         *{
         *  "command": "resendVerificationCode",
         *      "params":{
         *           "email":"testemail@gmail.com"
         *       }
         * }
         * */
        JSONObject body = new JSONObject();
        try {
            body.put("command", "resendVerificationCode");
            JSONObject params = new JSONObject();
            params.put("email", email);
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
        return entity;
    }

    public static StringEntity getVerifiedObject(String registrationToken, String userName, String password) {
        /**
         * set Verified json example
         *{
         * "command": "setVerified",
         * "params": {
         *           "registrationToken"  :5032,
         *           "userName":"desed1q",
         *           "password":"1231231q"
         *           }
         * }
         * */
        JSONObject body = new JSONObject();
        try {
            body.put("command", "setVerified");
            JSONObject params = new JSONObject();
            params.put("registrationToken", registrationToken);
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
        return entity;
    }
}
