package com.myweb.lab_mysql;

import android.app.Activity;
import android.os.Build;
import android.os.StrictMode;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class MySQLConnect {
    private final Activity main;
    private List<String> list;
    private String URL = "http://10.48.100.47/" , GET_URL = "loggin/get_post.php" , SENT_URL ="loggin/sent_post.php";
    public  MySQLConnect(MainActivity mainActivity){main = null;}
    public MySQLConnect(MainActivity mainActivity, Activity mainA) {

        main = mainA;
        list = new ArrayList<String>();
    }

    public void sentData(String value) {
        StrictMode.enableDefaults();
        if (Build.VERSION.SDK_INT > 9 ){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        try {
            ArrayList<NameValuePair> nameValuePairs = new ArrayFromIntity (nameValuePairs,encode)
        }
    }

    public List<String> getData() {
        String url = URL + GET_URL;
        //noinspection deprecation
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
                Toast.makeText(main, list.get(0), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(main,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(main.getApplicationContext());
        requestQueue.add(StringRequest);
        return list;
    }

    private void showJSON(String response) {
        String comment = "";
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");
            for (int i = 0; i <result.length();i++){
                JSONObject collectData = result.getJSONObject(i);
                comment = collectData.getString("comment");
                list.add(comment);
            }
        }catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    private class NameValuePair {
    }
}
