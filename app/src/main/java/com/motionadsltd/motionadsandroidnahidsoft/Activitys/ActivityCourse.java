package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityCourseBinding;

import java.util.TimerTask;

public class ActivityCourse extends AppCompatActivity {


    ActivityCourseBinding binding;
    private AdManagerInterstitialAd mAdManagerInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        loadAds();


    }

    private void loadAds() {
        AdManagerAdRequest interads = new AdManagerAdRequest.Builder().build();
        AdManagerInterstitialAd.load(this, getString(R.string.interads_admob), interads,
                new AdManagerInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                        // The mAdManagerInterstitialAd reference will be null until
                        // an ad is loaded.
                        mAdManagerInterstitialAd = interstitialAd;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mAdManagerInterstitialAd.show(ActivityCourse.this);
                            }
                        },4000);
                        //Toast.makeText(ActivityCourse.this, "Loaded", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mAdManagerInterstitialAd = null;
                        //Toast.makeText(ActivityCourse.this, "Not Loaded", Toast.LENGTH_SHORT).show();
                    }
                });

        AdView adView = new AdView(this);
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);
        binding.adView1.loadAd(adRequest);
        binding.adView2.loadAd(adRequest);

    }
}