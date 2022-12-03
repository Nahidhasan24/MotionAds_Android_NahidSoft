package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityWebTaskBinding;

public class WebTaskActivity extends AppCompatActivity {

    ActivityWebTaskBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWebTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}