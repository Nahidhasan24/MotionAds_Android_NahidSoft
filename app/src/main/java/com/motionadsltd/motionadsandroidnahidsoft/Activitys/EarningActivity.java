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
        binding.SpinBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),SpinActivity.class));
        });
        binding.QuizBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),QuizActivity.class));
        });
        binding.WebsitevisitBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),WebVisiteActivity.class));
        });
        binding.comingSoon.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),ScratchActivity.class));
        });
        binding.webTask.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),ScratchActivity.class));
        });


    }
}