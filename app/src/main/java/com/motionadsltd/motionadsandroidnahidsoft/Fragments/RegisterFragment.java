package com.motionadsltd.motionadsandroidnahidsoft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.FragmentHomeBinding;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {

    FragmentRegisterBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentRegisterBinding.inflate(inflater,container,false);


        binding.signupBtn.setOnClickListener(v->{

            String name,username,mail,number,password,confpassword;
            name=binding.nameInput.getText().toString();
            username=binding.usernameInput.getText().toString();
            mail=binding.mailInput.getText().toString();
            number=binding.numberInput.getText().toString();
            password=binding.passwordInput.getText().toString();
            confpassword=binding.confirmPasswordInput.getText().toString();
            
            if (name.isEmpty()){
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
           

        });


        return binding.getRoot();
    }
}