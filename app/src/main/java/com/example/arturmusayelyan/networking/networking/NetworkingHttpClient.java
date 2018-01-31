package com.example.arturmusayelyan.networking.networking;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by artur.musayelyan on 29/01/2018.
 */

public class NetworkingHttpClient {
    private static final String BASE_URL = "https://freemegalist.com/api.php/?action=categories";
    private static AsyncHttpClient httpClient = new AsyncHttpClient(true, 80, 443);

    public static void get(Context context, String url, RequestParams requestParams, AsyncHttpResponseHandler responseHandler) {
        httpClient.get(context, url, requestParams, responseHandler);
    }

    public static void post(Context context, String relativeUrl, StringEntity stringEntity, AsyncHttpResponseHandler responseHandler) {
        httpClient.post(context, relativeUrl, stringEntity, "application/json", responseHandler);
    }

    public static void cancelAllRequest() {
        httpClient.cancelAllRequests(true);
    }

    public static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

}
