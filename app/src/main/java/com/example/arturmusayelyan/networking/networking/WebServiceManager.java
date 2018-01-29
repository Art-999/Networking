package com.example.arturmusayelyan.networking.networking;

import android.content.Context;

import com.example.arturmusayelyan.networking.R;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * Created by artur.musayelyan on 29/01/2018.
 */

public class WebServiceManager {

    public static void getCall(Context context, AsyncHttpResponseHandler responseHandler) {
        NetworkingHttpClient.get(context, context.getString(R.string.get_call_url), null, responseHandler);
    }
}
