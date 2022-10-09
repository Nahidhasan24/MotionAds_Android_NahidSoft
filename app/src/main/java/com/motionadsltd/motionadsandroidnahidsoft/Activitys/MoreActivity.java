package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityMoreBinding;

public class MoreActivity extends AppCompatActivity {

    ActivityMoreBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.earningCard.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),EarningActivity.class));
        });
        binding.addMoneyBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),AddMoneyActivity.class));
        });
        binding.walletBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),WalletActivity.class));
        });
    }
}