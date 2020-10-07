package com.techmetix.realtimeinvestment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.json.JSONException;
import org.json.JSONObject;

public class MobileNoEntry extends AppCompatActivity {

    EditText mobno;
    Button mobilesubmit;
    String mob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_no_entry);

        mobno = findViewById(R.id.et_login_mobno);
        mobilesubmit = findViewById(R.id.btn_login_mobno);




    }

    public void submit(View view) {


        mob= mobno.getText().toString();
        if (mob.isEmpty() ){
            FancyToast.makeText(this,"Mobile number can't blank.",FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();
        } else if (mob.length()<10 ){
            FancyToast.makeText(this,"Mobile number can't less than 10 digits.",FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();

        }  else if ( mob.length()>10)
        {
            FancyToast.makeText(this,"Mobile number can't more than 10 digits.",FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();



        } else {
            otpsend();
        }

    }

    private void otpsend() {
        String URL = cont.url_sendotp+"91"+mob;
        Log.e("URL",URL);


        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Log.e("response",jsonObject.toString());
                           // JSONObject jsonObject1 = jsonObject.getJSONObject("data");

                            if (jsonObject.getString("type").equals("success")){

                                Intent intent = new Intent(MobileNoEntry.this,OtpVerify.class);

                                FancyToast.makeText(MobileNoEntry.this,"Your otp sent successfully !",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();

                                startActivity(intent);

                            } else {

                                FancyToast.makeText(MobileNoEntry.this,"Something went wrong,please try again !",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();




                             /*   SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                                SharedPreferences.Editor editor = pref.edit();

                                editor.putString("id",jsonObject1.getString("id"));
                                editor.putString("firstname",jsonObject1.getString("first_name"));
                                editor.putString("lastname",jsonObject1.getString("last_name"));

                                editor.commit();*/
                              //
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MobileNoEntry.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });



        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);



    }

}
