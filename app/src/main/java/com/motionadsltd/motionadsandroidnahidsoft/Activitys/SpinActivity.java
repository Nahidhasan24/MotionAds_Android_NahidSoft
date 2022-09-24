package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityScratchBinding;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivitySpinBinding;

import java.util.ArrayList;

public class SpinActivity extends AppCompatActivity {

    ActivitySpinBinding binding;
    ArrayList<WheelItem> wheelItemArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySpinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setWell();
        binding.lwv.addWheelItems(wheelItemArrayList);
        binding.lwv.setLuckyWheelReachTheTarget(() ->
                Toast.makeText(SpinActivity.this, "Target Reached", Toast.LENGTH_LONG).show());
        binding.spin.setOnClickListener(v->{
            binding.lwv.rotateWheelTo(2);
        });
    }

    private void setWell() {
        wheelItemArrayList.add(new WheelItem(Color.LTGRAY, BitmapFactory.decodeResource(getResources(), R.drawable.orange),"Win 1"));
        wheelItemArrayList.add(new WheelItem(Color.YELLOW, BitmapFactory.decodeResource(getResources(), R.drawable.orange),"Win 2"));
        wheelItemArrayList.add(new WheelItem(Color.CYAN, BitmapFactory.decodeResource(getResources(), R.drawable.orange),"Win 3"));
        wheelItemArrayList.add(new WheelItem(Color.MAGENTA, BitmapFactory.decodeResource(getResources(), R.drawable.orange),"Win 4"));
    }
}