package com.example.mobileprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static android.widget.Toast.*;




public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9, ed10, ed11, ed12, ed13, ed14, ed15, ed16, ed17, ed18, ed19, ed20;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);

        ed2 = findViewById(R.id.bl_t);
        ed2.setFilters(new InputFilter[]{new MinMaxFilter(this, 0, 1)});

        ed1 = findViewById(R.id.bat_pow);
        ed1.setFilters(new InputFilter[]{new MinMaxFilter(this, 0, 7000)});

        ed3 = findViewById(R.id.cl_sp);
        ed3.setFilters(new InputFilter[]{new MinMaxFilter(this, 0.5, 5.0)});

        ed4 = findViewById(R.id.du_si);
        ed4.setFilters(new InputFilter[]{new MinMaxFilter(this, 0, 1)});

        ed5 = findViewById(R.id.fc);
        ed5.setFilters(new InputFilter[]{new MinMaxFilter(this, 1, 200)});

        ed6 = findViewById(R.id.fg);
        ed6.setFilters(new InputFilter[]{new MinMaxFilter(this, 0, 1)});

        ed7 = findViewById(R.id.in_mm);
        ed7.setFilters(new InputFilter[]{new MinMaxFilter(this, 8, 512)});

        ed8 = findViewById(R.id.m_dp);
        ed8.setFilters(new InputFilter[]{new MinMaxFilter(this, 0.1, 5.0)});

        ed9 = findViewById(R.id.m_w);
        ed9.setFilters(new InputFilter[]{new MinMaxFilter(this, 5, 800)});

        ed10 = findViewById(R.id.n_co);
        ed10.setFilters(new InputFilter[]{new MinMaxFilter(this, 2, 16)});

        ed11 = findViewById(R.id.pc);
        ed11.setFilters(new InputFilter[]{new MinMaxFilter(this, 2, 200)});

        ed12 = findViewById(R.id.px_h);
        ed12.setFilters(new InputFilter[]{new MinMaxFilter(this, 9, 2000)});

        ed13 = findViewById(R.id.px_w);
        ed13.setFilters(new InputFilter[]{new MinMaxFilter(this, 9, 2000)});

        ed14 = findViewById(R.id.r);
        ed14.setFilters(new InputFilter[]{new MinMaxFilter(this, 9, 5000)});

        ed15 = findViewById(R.id.sc_h);
        ed15.setFilters(new InputFilter[]{new MinMaxFilter(this, 5, 20)});

        ed16 = findViewById(R.id.sc_w);
        ed16.setFilters(new InputFilter[]{new MinMaxFilter(this, 0, 20)});

        ed17 = findViewById(R.id.tt);
        ed17.setFilters(new InputFilter[]{new MinMaxFilter(this, 2, 30)});

        ed18 = findViewById(R.id.tg);
        ed18.setFilters(new InputFilter[]{new MinMaxFilter(this, 0, 1)});

        ed19 = findViewById(R.id.t_sc);
        ed19.setFilters(new InputFilter[]{new MinMaxFilter(this, 0, 1)});

        ed20 = findViewById(R.id.wf);
        ed20.setFilters(new InputFilter[]{new MinMaxFilter(this, 0, 1)});


    }

    public void submit(View view) {
        RequestQueue Queue= Volley.newRequestQueue(this);
        final String url = "url...goes...here";
        JSONObject postparams = new JSONObject();
        try{
            postparams.put("battery_power",ed1.getText().toString());
            postparams.put("blue", ed2.getText().toString());
            postparams.put("clock_speed", ed3.getText().toString());
            postparams.put("dual_sim", ed4.getText().toString());
            postparams.put("fc", ed5.getText().toString());
            postparams.put("four_g", ed6.getText().toString());
            postparams.put("int_memory", ed7.getText().toString());
            postparams.put("m_dep", ed8.getText().toString());
            postparams.put("mobile_wt", ed9.getText().toString());
            postparams.put("n_cores", ed10.getText().toString());
            postparams.put("Pc", ed11.getText().toString());
            postparams.put("Px_height", ed12.getText().toString());
            postparams.put("Px_width", ed13.getText().toString());
            postparams.put("ram", ed14.getText().toString());
            postparams.put("sc_h", ed15.getText().toString());
            postparams.put("sc_w", ed16.getText().toString());
            postparams.put("talk_time", ed17.getText().toString());
            postparams.put("three_g", ed18.getText().toString());
            postparams.put("touch_screen", ed19.getText().toString());
            postparams.put("wifi", ed20.getText().toString());
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, postparams, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("On Response","onResponse:"+response.toString());
                Toast.makeText(MainActivity.this,""+response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("On Error",error.toString());
                Toast.makeText(MainActivity.this,""+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Queue.add(jsonObjectRequest);
    }


}