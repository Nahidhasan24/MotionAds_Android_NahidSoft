package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.signupBtn.setOnClickListener(v->{

            String name,username,mail,number,password,confpassword;
            int phoneNumber;
            name=binding.nameInput.getText().toString();
            username=binding.usernameInput.getText().toString();
            mail=binding.mailInput.getText().toString();
            number=binding.numberInput.getText().toString();
            password=binding.passwordInput.getText().toString();
            confpassword=binding.confirmPasswordInput.getText().toString();
            phoneNumber=Integer.parseInt(number);

            if (name.isEmpty()){
                Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (username.isEmpty()){
                Toast.makeText(getApplicationContext(), "UserName is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (mail.isEmpty()){
                Toast.makeText(getApplicationContext(), "Mail is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (number.isEmpty()){
                Toast.makeText(getApplicationContext(), "Number is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (password.isEmpty()){
                Toast.makeText(getApplicationContext(), "Password is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (confpassword.isEmpty()){
                Toast.makeText(getApplicationContext(), "Confirm Password is Empty", Toast.LENGTH_SHORT).show();
                return;
            }if (phoneNumber<=11){
                Toast.makeText(getApplicationContext(), "Confirm Password is Empty", Toast.LENGTH_SHORT).show();
                return;
            }


        });
    }
}