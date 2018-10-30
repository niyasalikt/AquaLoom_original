package com.example.niyasali.nav;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {
    String URL_POST = "https://aqualoom.000webhostapp.com/index.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_register);
        Button reg=(Button)findViewById(R.id.btnReg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtDist=(EditText)findViewById(R.id.edtDistrict);
                EditText edttaluk=(EditText)findViewById(R.id.edttaluk);
                EditText edtpanchayath=(EditText)findViewById(R.id.edtpanchayath);
                EditText edtcategory=(EditText)findViewById(R.id.edtcategory);
                //taking values from edittext convert to string
                String district=edtDist.getText().toString();
                String taluk=edttaluk.getText().toString();
                String panchayath=edtpanchayath.getText().toString();
                String category=edtcategory.getText().toString();
                //
                InsertSV(district,taluk,panchayath);

               Intent intent=new Intent(register.this,thank.class);
                startActivity(intent);
            }
        });
    }
    public void InsertSV(final String district, final String taluk, final String panchayath){
        HttpsTrustManager.allowAllSSL();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_POST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(register.this, response, Toast.LENGTH_SHORT).show();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(register.this, error.toString() , Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();


                //  params.put("QUESTION",question);
                params.put("fname", district);
                params.put("lname", taluk);
                params.put("email", panchayath);


                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


}
