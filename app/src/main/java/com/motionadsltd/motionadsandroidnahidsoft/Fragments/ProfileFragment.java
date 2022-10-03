package com.motionadsltd.motionadsandroidnahidsoft.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.motionadsltd.motionadsandroidnahidsoft.Activitys.WalletActivity;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentProfileBinding.inflate(inflater,container,false);

        binding.walletBtn.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), WalletActivity.class));
        });


        return binding.getRoot();
    }
}