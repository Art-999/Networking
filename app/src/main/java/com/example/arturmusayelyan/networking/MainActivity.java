package com.example.arturmusayelyan.networking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.arturmusayelyan.networking.models.ChildCats;
import com.example.arturmusayelyan.networking.models.ParentsCat;
import com.example.arturmusayelyan.networking.utils.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button getButton;
    private TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getButton = findViewById(R.id.get_button);
        resultTv = findViewById(R.id.result_tv);
        getButton.setOnClickListener(this);
        getButton.setEnabled(true);
    }

    @Override
    public void onClick(View v) {
        //simple example
        AsyncHttpClient httpClient = new AsyncHttpClient(true, 80, 443);
        switch (v.getId()) {
            case R.id.get_button:
                httpClient.get("https://freemegalist.com/api.php/?action=categories", new AsyncHttpResponseHandler() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        getButton.setEnabled(false);
                        resultTv.setText("");
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if (responseBody != null) {
                            try {
                                JSONArray jsonArray = new JSONArray(new String(responseBody));
                                resultTv.setText(jsonArray + "");
                                List<ParentsCat> parentsCatList = JsonParser.parseJsonToParentsCatList(jsonArray);
                                Log.d("Art",parentsCatList.toString());

                                JSONObject jsonObject=jsonArray.optJSONObject(0);
                                ParentsCat parentsCat=JsonParser.parseToParentsCatObject(jsonObject);
                                Log.d("Art",parentsCat.toString());

                                List<ChildCats> childCats=JsonParser.parseJsonToChildCatsList(jsonObject.getJSONArray("children_cats"));
                                Log.d("Art",childCats.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        getButton.setEnabled(true);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });
                break;
        }
    }

}
