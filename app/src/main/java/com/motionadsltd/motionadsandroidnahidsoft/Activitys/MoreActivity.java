package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
        binding.news.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(), ComingActivity.class));
        });
        binding.addMoneyBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),AddMoneyActivity.class));
        });

        binding.walletBtn.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),WalletActivity.class));
        });
        binding.game.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(),GameActivity.class));
        });

        binding.scaner.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(), ComingActivity.class));
        });
        binding.taxc.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(), ComingActivity.class));
        });
        binding.community.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(), ComingActivity.class));
        });
        binding.rideshare.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(), ComingActivity.class));
        });
        binding.wheather.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(), ComingActivity.class));
        });
        binding.more2.setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext(), ComingActivity.class));
        });



    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}