package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.motionadsltd.motionadsandroidnahidsoft.Configs.Const;
import com.motionadsltd.motionadsandroidnahidsoft.Models.QuizModel;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityQuizBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    ArrayList<QuizModel> quizModelArrayList = new ArrayList<>();
    QuizModel quizModel;
    boolean isSelected=false;
    String selectedPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setDataToList();

        //loadFastData();
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                isSelected=true;
                selectedPos=getPosition(i);
            }
        });
        binding.nextBtn.setOnClickListener(v -> {
            if (!isSelected){
                Toast.makeText(this, "Select fast", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, ""+selectedPos, Toast.LENGTH_SHORT).show();

        });

    }


    private void loadFastData(ArrayList<QuizModel> qm) {
        int index;
        index = getIndex();
        binding.titleQuiz.setText(qm.get(index).getTittle());
        binding.opOne.setText(qm.get(index).getOpOne());
        binding.opTwo.setText(qm.get(index).getOpTwo());
        binding.opThree.setText(qm.get(index).getOpThree());
        binding.opFour.setText(qm.get(index).getOpFour());
        loadTimer();
    }

    private void loadTimer() {
        CountDownTimer count = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                int seconds = (int) ((l / 1000) % 60);
                binding.timeLeftTV.setText(seconds + " second");
            }

            @Override
            public void onFinish() {
                Toast.makeText(QuizActivity.this, "TimeUp !", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void setDataToList() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Const.BASE_URL + "getQuiz", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("data");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int id = jsonObject.getInt("id");
                        String title = jsonObject.getString("question");
                        String q1 = jsonObject.getString("optiona");
                        String q2 = jsonObject.getString("optionb");
                        String q3 = jsonObject.getString("optionc");
                        String q4 = jsonObject.getString("optiond");
                        String ans = jsonObject.getString("answer");
                        quizModelArrayList.add(new QuizModel(title, q1, q2, q3, q4, ans, id));
                    }
                    loadFastData(quizModelArrayList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);

    }

    private int getIndex() {
        int random = ThreadLocalRandom.current().nextInt(0, quizModelArrayList.size());
        return random;
    }
//    private int getSelectedPosition(){
//
//    }

    String getPosition(int id){
        String selection=null;
        if (id==R.id.opOne){
            selection="a";
        }else if (id==R.id.opTwo){
            selection="b";
        }else if (id==R.id.opThree){
            selection="c";
        }else if (id==R.id.opFour){
            selection="d";
        }
        return selection;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}