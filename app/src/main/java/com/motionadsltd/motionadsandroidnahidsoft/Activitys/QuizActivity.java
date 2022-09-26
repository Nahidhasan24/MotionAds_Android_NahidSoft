package com.motionadsltd.motionadsandroidnahidsoft.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.motionadsltd.motionadsandroidnahidsoft.Models.QuizModel;
import com.motionadsltd.motionadsandroidnahidsoft.R;
import com.motionadsltd.motionadsandroidnahidsoft.databinding.ActivityQuizBinding;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    ArrayList<QuizModel> quizModelArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setDataToList();
        loadFastData();
        binding.nextBtn.setOnClickListener(v->{

        });

    }


    private void loadFastData() {
        int index;
        index=getIndex();
        binding.titleQuiz.setText(quizModelArrayList.get(index).getTittle());
        binding.opOne.setText(quizModelArrayList.get(index).getOpOne());
        binding.opTwo.setText(quizModelArrayList.get(index).getOpTwo());
        binding.opThree.setText(quizModelArrayList.get(index).getOpThree());
        binding.opFour.setText(quizModelArrayList.get(index).getOpFour());
        loadTimer();
    }

    private void loadTimer() {
        CountDownTimer count=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                int seconds = (int) ((l / 1000) % 60);
                binding.timeLeftTV.setText(seconds+" second");
            }

            @Override
            public void onFinish() {
                Toast.makeText(QuizActivity.this, "TimeUp !", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void setDataToList() {
        quizModelArrayList.add(new QuizModel("What is Lunex basde oporating systme 1","window","apple","android","ubanto",3));
        quizModelArrayList.add(new QuizModel("What is Lunex basde oporating systme 2","window","apple","android","ubanto",3));
        quizModelArrayList.add(new QuizModel("What is Lunex basde oporating systme 3","window","apple","android","ubanto",3));
        quizModelArrayList.add(new QuizModel("What is Lunex basde oporating systme 4","window","apple","android","ubanto",3));
    }
    private int getIndex(){
        int random = ThreadLocalRandom.current().nextInt(0, quizModelArrayList.size());
        return random;
    }
//    private int getSelectedPosition(){
//
//    }

    @Override
    public void onBackPressed() {
        finish();
    }
}