package com.motionadsltd.motionadsandroidnahidsoft.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.motionadsltd.motionadsandroidnahidsoft.Activitys.TaskActivity;
import com.motionadsltd.motionadsandroidnahidsoft.Adapters.SliderImageAdapter;
import com.motionadsltd.motionadsandroidnahidsoft.Models.SliderItem;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<SliderItem> slideModelArrayList=new ArrayList<>();
    SliderImageAdapter sliderImageAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(inflater,container,false);
        loadSliderImage();
        binding.workBtn.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), TaskActivity.class));
        });


        return binding.getRoot();
    }

    private void loadSliderImage() {
        slideModelArrayList.add(new SliderItem("https://firebasestorage.googleapis.com/v0/b/crypto-coin-mine.appspot.com/o/images%2FCAR%20GAME-320x100-px.png?alt=media&token=ca9ea7e6-c6b3-4b2e-bbf5-20c26d68695b",""));
        slideModelArrayList.add(new SliderItem("https://image.shutterstock.com/image-vector/important-notice-sign-on-white-260nw-2065743164.jpg",""));
        slideModelArrayList.add(new SliderItem("https://image.shutterstock.com/image-vector/important-notice-sign-on-white-260nw-2065743164.jpg",""));
        slideModelArrayList.add(new SliderItem("https://image.shutterstock.com/image-vector/important-notice-sign-on-white-260nw-2065743164.jpg",""));
        sliderImageAdapter=new SliderImageAdapter(getActivity());
        sliderImageAdapter.renewItems(slideModelArrayList);
        binding.imageSlider.setSliderAdapter(sliderImageAdapter);
        binding.imageSlider.startAutoCycle();
    }
}