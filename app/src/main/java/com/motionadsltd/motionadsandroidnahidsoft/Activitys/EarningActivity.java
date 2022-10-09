package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityEarningBinding;

public class EarningActivity extends AppCompatActivity {

    ActivityEarningBinding  binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEarningBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.spinBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),SpinActivity.class));
        });
        binding.quizBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),QuizActivity.class));
        });
        binding.webVisitBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),WebVisiteActivity.class));
        });

    }
}