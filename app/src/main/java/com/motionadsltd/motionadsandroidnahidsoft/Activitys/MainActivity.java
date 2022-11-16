package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.motionadsltd.motionadsandroidnahidsoft.Fragments.HistoryFragment;
import com.motionadsltd.motionadsandroidnahidsoft.Fragments.HomeFragment;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setBottomView();
        binding.bottomBar.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                if (item.getId() == 1) {
                    replaceFragment(new HomeFragment());
                } else if (item.getId() == 3) {
                    startActivity(new Intent(getApplicationContext(), AddMoneyActivity.class));
                    finish();
                }else if (item.getId()==4){
                    replaceFragment(new HistoryFragment());
                }else if (item.getId()==5){
                    replaceFragment(new ProfileFragment());
                }
            }
        });
        //binding.bottomBar.setCount(1,"");
        binding.bottomBar.show(1, true);
        binding.bottomBar.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });
        binding.bottomBar.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });

    }

    private void setBottomView() {
        binding.bottomBar.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        binding.bottomBar.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_groups_2_24));
        binding.bottomBar.add(new MeowBottomNavigation.Model(5, R.drawable.ic_baseline_person_24));
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}