package com.example.ch4practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private String [] questions = {"Android is a framework?", "Android has jelly bean version?","Android is the famous os?","Android was introduced in 2000?","Android has official docs?"};
private  boolean[] answers= {false,true,true,false,true};
private int score = 0;
private int index=0;

Button yes;
Button no;
TextView question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);

      question=findViewById(R.id.question);
      question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index<=questions.length-1){
// If you have given correct answer
                    if (answers[index]){
                        score++;
                    }
                    // Go to next question
                    index++;// deal with the question
                    if (index<=questions.length-1){
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your Score is: "+score + "/" + questions.length , Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again" , Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the array is not going out of bounds
if (index<=questions.length-1){
// If you have given correct answer
  if (!answers[index]){
score++;
}
  // Go to next question
index++;// deal with the question
if (index<=questions.length-1){
question.setText(questions[index]);
     }
     else{
Toast.makeText(MainActivity.this, "Your Score is: "+score + "/" + questions.length , Toast.LENGTH_SHORT).show();
}
  }
else{
    Toast.makeText(MainActivity.this, "Restart the app to play again" , Toast.LENGTH_SHORT).show();
}
            }
        });
    }
}