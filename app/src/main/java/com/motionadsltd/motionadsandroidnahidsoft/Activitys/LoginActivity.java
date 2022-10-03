package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.annotation.Nullable;
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
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressDialog=new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Loading...");
        progressDialog.setCancelable(false);
        
        Paper.init(getApplicationContext());
        if (Paper.book().read(Const.ID) != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        binding.sendRegisterBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
        });
        binding.signInBtn.setOnClickListener(v -> {
            String name, pass;
            name = binding.usernameInput.getText().toString();
            pass = binding.passwordInput.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(this, "Name Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (pass.isEmpty()) {
                Toast.makeText(this, "Password Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            progressDialog.show();
            RequestQueue queue = Volley.newRequestQueue(this);

            //calling api
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Const.BASE_URL + "login",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            try {
                                JSONObject result = new JSONObject(response);
                                String massage = result.getString("message");
                                if (massage.equals("success")) {

                                    JSONObject mainObject = result.getJSONObject("data");
                                    String name, phone, mail, referCode, type, refer, balance;
                                    int id;
                                    //getting data from server
                                    name = mainObject.getString("motion_ad_user_name");
                                    phone = mainObject.getString("motion_ad_user_phone");
                                    mail = mainObject.getString("motion_ad_user_mail");
                                    referCode = mainObject.getString("user_refer_code");
                                    type = mainObject.getString("motion_ad_user_type");
                                    refer = mainObject.getString("reffered_code");
                                    balance = mainObject.getString("used");
                                    id = mainObject.getInt("motion_ad_user_id");

                                    //putting data on offline database
                                    Paper.book().write(Const.ID, id);
                                    Paper.book().write(Const.USER_NAME, name);
                                    Paper.book().write(Const.USER_MAIL, mail);
                                    Paper.book().write(Const.USER_NUMBER, phone);
                                    Paper.book().write(Const.USER_ACCOUNT_TYPE, type);
                                    Paper.book().write(Const.USER_REFER_CODE, referCode);

                                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                                    //passing main page
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    finish();

                                } else {
                                    progressDialog.dismiss();
                                    Toast.makeText(LoginActivity.this, "Wrong Credential", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    //error
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }) {


                //sending data to server
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("motion_ad_user_name", name);
                    hashMap.put("motion_ad_user_password", pass);

                    return hashMap;
                }
            };

            queue.add(stringRequest);


        });


    }
}