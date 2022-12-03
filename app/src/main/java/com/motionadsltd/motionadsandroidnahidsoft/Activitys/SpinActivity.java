package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityScratchBinding;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivitySpinBinding;

import java.util.ArrayList;

public class SpinActivity extends AppCompatActivity {

    ActivitySpinBinding binding;
    ArrayList<WheelItem> wheelItemArrayList = new ArrayList<>();
    private MaxInterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadAdMobads();
        AppLovinSdk.getInstance(this).showMediationDebugger();
        AppLovinSdk.initializeSdk(getApplicationContext(), new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration) {
                // AppLovin SDK is initialized, start loading ads
                //Toast.makeText(ScratchActivity.this, ""+configuration.getConsentDialogState(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(ScratchActivity.this, ""+configuration.toString(), Toast.LENGTH_SHORT).show();
                createInterstitialAd();
            }
        });
        setWell();
        binding.lwv.addWheelItems(wheelItemArrayList);
        binding.lwv.setLuckyWheelReachTheTarget(() -> {
            loadAds();
        });
        //Toast.makeText(SpinActivity.this, "Target Reached", Toast.LENGTH_LONG).show());
        binding.spin.setOnClickListener(v -> {
            binding.lwv.rotateWheelTo(2);
        });
    }

    private void loadAdMobads() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                AdView adView = new AdView(SpinActivity.this);
                AdRequest adRequest = new AdRequest.Builder().build();
                binding.adView.loadAd(adRequest);
            }
        });
    }

    private void loadAds() {
        if ( interstitialAd.isReady() )
        {
            interstitialAd.showAd();
        }
    }
    void createInterstitialAd()
    {
        interstitialAd = new MaxInterstitialAd( "99a193f4d13e19d8", this );
        interstitialAd.setListener(new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd ad) {


            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {
                addCoin();

            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {

            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        });

        // Load the first ad
        interstitialAd.loadAd();
    }
    private void addCoin() {
        Toast.makeText(this, "Give Coin", Toast.LENGTH_SHORT).show();
    }

    private void setWell() {
        wheelItemArrayList.add(new WheelItem(Color.LTGRAY, BitmapFactory.decodeResource(getResources(), R.drawable.orange), "Win 1"));
        wheelItemArrayList.add(new WheelItem(Color.YELLOW, BitmapFactory.decodeResource(getResources(), R.drawable.orange), "Win 2"));
        wheelItemArrayList.add(new WheelItem(Color.CYAN, BitmapFactory.decodeResource(getResources(), R.drawable.orange), "Win 3"));
        wheelItemArrayList.add(new WheelItem(Color.MAGENTA, BitmapFactory.decodeResource(getResources(), R.drawable.orange), "Win 4"));
    }
}