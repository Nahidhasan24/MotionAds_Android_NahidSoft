package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.anupkumarpanwar.scratchview.ScratchView;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityScratchBinding;

public class ScratchActivity extends AppCompatActivity {

    ActivityScratchBinding binding;
    private MaxInterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityScratchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppLovinSdk.getInstance(this).showMediationDebugger();
        AppLovinSdk.initializeSdk(getApplicationContext(), new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
            {
                // AppLovin SDK is initialized, start loading ads
                //Toast.makeText(ScratchActivity.this, ""+configuration.getConsentDialogState(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(ScratchActivity.this, ""+configuration.toString(), Toast.LENGTH_SHORT).show();
            }
        } );
        createInterstitialAd();
        binding.scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                Toast.makeText(getApplicationContext(), "Reveled", Toast.LENGTH_LONG).show();
                binding.scratchView.clear();
                loadAds();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {

            }
        });
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

    private void loadAds() {

        if ( interstitialAd.isReady() )
        {
            interstitialAd.showAd();
        }
        //
    }
}