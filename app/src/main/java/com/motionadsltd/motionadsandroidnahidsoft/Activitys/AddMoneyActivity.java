package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
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
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityAddMoneyBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import io.paperdb.Paper;

public class AddMoneyActivity extends AppCompatActivity {

    ActivityAddMoneyBinding binding;
    String method;
    String TAG = "MyTag";
    boolean isSelected = false;
    String name, phone, tranid, amount, date, id;
    int tmpID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddMoneyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Paper.init(getApplicationContext());

        name = Paper.book().read(Const.USER_NAME, "");
        tmpID = Paper.book().read(Const.ID, 1);
        id = String.valueOf(tmpID);


//        Log.d(TAG, "ID: "+Paper.book().read(Const.ID));
//        Log.d(TAG, "Name: "+Paper.book().read(Const.USER_NAME));
//        Log.d(TAG, "Mail: "+Paper.book().read(Const.USER_MAIL));
//        Log.d(TAG, "Refer: "+Paper.book().read(Const.USER_REFER_CODE));
//        Log.d(TAG, "Number: "+Paper.book().read(Const.USER_NUMBER));

        binding.radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            method = getMethod(i);
            isSelected = true;
            //Toast.makeText(AddMoneyActivity.this, "" + getMethod(i), Toast.LENGTH_SHORT).show();
        });
        binding.submitBtn.setOnClickListener(v -> {

            phone = binding.senderNumber.getText().toString();
            tranid = binding.tranID.getText().toString();
            amount = binding.amount.getText().toString();


            if (phone.isEmpty()) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (tranid.isEmpty()) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (amount.isEmpty()) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!isSelected) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
                return;
            }

            sendData(name, phone, tranid, amount, method, id);

        });


    }

    private void sendData(String name, String phone, String tranid, String amount, String method, String id) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Const.BASE_URL + "addMoney", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String massage = jsonObject.getString("message");
                    if (massage.equals("success")) {
                        Toast.makeText(AddMoneyActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AddMoneyActivity.this, "Wrong Credential", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddMoneyActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("user_id", id);
                hashMap.put("name", name);
                hashMap.put("phone", phone);
                hashMap.put("transaction_id", tranid);
                hashMap.put("method", method);
                hashMap.put("amount", amount);
                hashMap.put("date", getTimeDate());

                return hashMap;
            }
        };
        queue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MoreActivity.class));
        finish();
    }

    String getMethod(int id) {
        String ty = "";
        if (id == R.id.AddBkash) {
            ty = "Bkash";
        } else if (id == R.id.AddNagad) {
            ty = "Nagad";
        } else if (id == R.id.AddRocket) {
            ty = "Rocket";
        }

        return ty;
    }

    private String getTimeDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }
}