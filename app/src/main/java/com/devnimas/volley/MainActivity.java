package com.devnimas.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private Button btnParse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parseJson();
            }
        });
    }


    private void init() {
        textViewResult = findViewById(R.id.textview_result);
        btnParse = findViewById(R.id.btn_parse);
    }

    private void parseJson() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url ="https://api.myjson.com/bins/kp9wz";
        StringRequest  stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textViewResult.setText("The response is : "+ response.substring(0,500));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textViewResult.setText(error.getMessage());
                error.printStackTrace();
            }
        });
        requestQueue.add(stringRequest);

    }

}