package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

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
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityWithdrawBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.stream.StreamResult;

import io.paperdb.Paper;

public class WithdrawActivity extends AppCompatActivity {

    ActivityWithdrawBinding binding;
    String address,amount,id,balance;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWithdrawBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Paper.init(getApplicationContext());
        int tmp=Paper.book().read(Const.ID,0);
        id=String.valueOf(tmp);
        getDataFromApi();
        binding.submitw.setOnClickListener(v->{
            address=binding.wdMail.getText().toString();
            amount=binding.dwPoint.getText().toString();
            if (address.isEmpty()){
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (amount.isEmpty()){
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (point<100){
                Toast.makeText(this, "Poor", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

        });

    }
    private void getDataFromApi() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.POST, Const.BASE_URL + "getProfile", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);

                    String res=jsonObject.getString("message");
                    if (res.equals("success")){
                        JSONObject json=jsonObject.getJSONObject("data");
                        balance=json.getString("used");
                        point=Integer.parseInt(balance);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WithdrawActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("motion_ad_user_id", id);
                return hashMap;
            }
        };
        queue.add(request);
    }
}