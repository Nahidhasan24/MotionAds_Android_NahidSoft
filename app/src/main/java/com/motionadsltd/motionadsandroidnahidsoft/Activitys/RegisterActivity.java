package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.motionadsltd.motionadsandroidnahidsoft.Configs.Const;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityRegisterBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressDialog=new ProgressDialog(RegisterActivity.this);
        progressDialog.setTitle("Loading...");
        progressDialog.setCancelable(false);
        binding.sendLoginBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        });
        binding.signupBtn.setOnClickListener(v->{

            String name,username,mail,number,password,confpassword;
            int phoneNumber = 0;
            name=binding.nameInput.getText().toString();
            username=binding.usernameInput.getText().toString();
            mail=binding.mailInput.getText().toString();
            number=binding.numberInput.getText().toString();
            password=binding.passwordInput.getText().toString();
            confpassword=binding.confirmPasswordInput.getText().toString();
            if (!confpassword.isEmpty()){
                phoneNumber=Integer.parseInt(number);
            }

            
            if (name.isEmpty()){
                Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (username.isEmpty()){
                Toast.makeText(getApplicationContext(), "UserName is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (mail.isEmpty()){
                Toast.makeText(getApplicationContext(), "Mail is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (number.isEmpty()){
                Toast.makeText(getApplicationContext(), "Number is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (password.isEmpty()){
                Toast.makeText(getApplicationContext(), "Password is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (confpassword.isEmpty()){
                Toast.makeText(getApplicationContext(), "Confirm Password is Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            
            if (phoneNumber<=11){
                Toast.makeText(getApplicationContext(), "Confirm Password is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (!password.equals(confpassword)){
                Toast.makeText(this, "Password Not Same", Toast.LENGTH_SHORT).show();
                return;
            }

            progressDialog.show();
            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest stringRequest=new StringRequest(Request.Method.POST, Const.BASE_URL + "auth", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    try {
                        JSONObject result=new JSONObject(response);
                        String massage=result.getString("message");
                        if (massage.equals("success")){

                            Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("motion_ad_user_name", name);
                    hashMap.put("motion_ad_user_mail", mail);
                    hashMap.put("motion_ad_user_phone", number);
                    hashMap.put("motion_ad_user_confirm_password", confpassword);
                    hashMap.put("motion_ad_user_password", password);

                    return hashMap;
                }
            };

            queue.add(stringRequest);


        });
    }
}