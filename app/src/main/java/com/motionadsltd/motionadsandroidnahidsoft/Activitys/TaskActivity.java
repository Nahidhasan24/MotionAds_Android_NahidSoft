package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityTaskBinding;

public class TaskActivity extends AppCompatActivity {

    ActivityTaskBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.scratchCardBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),ScratchActivity.class));
        });
        binding.SpinWheelBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),SpinActivity.class));
        });
    }
}