package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityEarningBinding;

public class EarningActivity extends AppCompatActivity {

    ActivityEarningBinding  binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEarningBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}