package com.najd1182687.najd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class scoreActivity extends AppCompatActivity {

    private Button Retake,Home;
    private TextView score,description;
    public static long mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);



         saveSharedPref();

        Retake=(Button)findViewById(R.id.buttonRetake);
        Home=(Button)findViewById(R.id.buttonHome);
        score=(TextView) findViewById(R.id.textViewScore);
        description=(TextView)findViewById(R.id.textViewDescription);


        Retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reset score & timer

                 MainActivity.finalScore=0;
                 Intent intent=new Intent(scoreActivity.this , analysisTestActivity.class);
                 startActivity(intent);
                 finish();
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 MainActivity.finalScore=0;
                 Intent intent=new Intent(scoreActivity.this , MainActivity.class);
                 startActivity(intent);
                 finishAffinity();
            }
        });

        //int quC=(MainActivity.finalScore*100/30);
       // long timeC=36000/q1Activity.getTime();
        //if(timeC>70){timeC=70;}
      //  if(quC>95){quC=95;}
      //  mScore=  timeC+quC;
     //  if(mScore<70){mScore=70;}
      // else if(mScore>170){mScore=170;}

        score.setText(""+MainActivity.mathScore);
        if (MainActivity.mathScore<6){description.setText("Short");}
        else if ((MainActivity.mathScore>=6)&&(MainActivity.mathScore<10)){description.setText("Good");}
        else if ((MainActivity.mathScore>=10)&&(MainActivity.mathScore<14)){description.setText("Superior");}
        else if (MainActivity.mathScore>=14){description.setText("GENIUS!");}



    }
//the save function that saves the data inside the saveSharedPref object to be loaded everytime we use the app..
    public void saveSharedPref(){
        SharedPreferences sharedPreferences= getSharedPreferences(MainActivity.SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean(MainActivity.TEST_1_DONE,MainActivity.test1Done);
        editor.putBoolean(MainActivity.TEST_2_DONE,MainActivity.test2Done);
        editor.putBoolean(MainActivity.TEST_3_DONE,MainActivity.test3Done);
        editor.putBoolean(MainActivity.TEST_4_DONE,MainActivity.test4Done);
        editor.putFloat(ProfileActivity.IQ1,ProfileActivity.iq1);
        editor.putFloat(ProfileActivity.IQ2,ProfileActivity.iq2);
        editor.putFloat(ProfileActivity.IQ3,ProfileActivity.iq3);
        editor.putFloat(ProfileActivity.IQ6,ProfileActivity.iq6);
        editor.apply();

    }
}
