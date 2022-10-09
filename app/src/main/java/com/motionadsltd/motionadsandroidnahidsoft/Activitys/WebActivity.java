package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityWebBinding;

public class WebActivity extends AppCompatActivity {

    ActivityWebBinding binding;
    String url;
    long time;
    boolean isBack=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWebBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.setWebChromeClient(new WebChromeClient());
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.loadUrl(url);
        CountDownTimer count=new CountDownTimer(time,1000) {
            @Override
            public void onTick(long l) {
                long time=l/1000;
                binding.webTimeTV.setText(time+" sec");
            }

            @Override
            public void onFinish() {
                isBack=true;
                binding.webTimeTV.setText("0 sec");
            }
        }.start();

    }

    @Override
    public void onBackPressed() {
        if (isBack){
            super.onBackPressed();
        }
    }
}