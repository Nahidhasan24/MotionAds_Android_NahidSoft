package com.motionadsltd.motionadsandroidnahidsoft.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.motionadsltd.motionadsandroidnahidsoft.Activitys.WalletActivity;
import com.motionadsltd.motionadsandroidnahidsoft.Configs.Const;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.FragmentProfileBinding;

import io.paperdb.Paper;


public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentProfileBinding.inflate(inflater,container,false);
        Paper.init(getContext());

        binding.fullName.setText(Paper.book().read(Const.USER_NAME));
        binding.userName.setText(Paper.book().read(Const.USER_NAME));
        binding.mail.setText(Paper.book().read(Const.USER_MAIL));
        binding.number.setText(Paper.book().read(Const.USER_NUMBER));
        binding.referCode.setText(Paper.book().read(Const.USER_REFER_CODE));

        return binding.getRoot();
    }
}