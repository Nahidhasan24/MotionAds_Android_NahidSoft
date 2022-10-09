package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.motionadsltd.motionadsandroidnahidsoft.Fragments.HistoryFragment;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityWalletBinding;

public class WalletActivity extends AppCompatActivity {

    ActivityWalletBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWalletBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.WithdrawBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),WithdrawActivity.class));
        });
        binding.HistoryBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(), HistoryFragment.class));
        });



    }
}