package com.najd1182687.najd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.flurry.android.FlurryAgent;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private ImageView imageViewTest1,imageViewTest2,imageViewTest3,imageViewTest4;
    private TextView textViewTest1,textViewTest2,textViewTest3,textViewTest4;
    private ConstraintLayout viewTest1,viewTest2,viewTest3,viewTest4;
    private BottomNavigationView bottomNavigationView;
    private ProgressBar progressBar;
    private TextView percentage;
    public static Button goPremium;
    String texts[]=new String[4];
    Drawable icon[]=new Drawable[4];

   // private AdView adView;

    public static int finalScore=0;
    public static int coins=9000;
    public static int currentTest=0;
    public static int mathScore=0;
    public static int noOfCompletedTests=0;
    public static boolean test1Done,test2Done,test3Done,test4Done;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEST_1_DONE = "test1Done",TEST_2_DONE = "test2Done",TEST_3_DONE = "test3Done",TEST_4_DONE = "test4Done";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new FlurryAgent.Builder()
                .withLogEnabled(true)
                .build(this, "3YCTW9KSCR86DPK7359Y");

//**************************************** Declare Texts and Icons ***************************************
        texts[0]="Soccer Quiz"; texts[1]="Basketball Quiz";
        texts[2]="Fitness Quiz"; texts[3]="Overall Quiz";

        icon[0]=getDrawable(R.drawable.testicon1);
        icon[1]=getDrawable(R.drawable.testicon2);
        icon[2]=getDrawable(R.drawable.testicon3);
        icon[3]=getDrawable(R.drawable.testicon4);


//**************************************** set views variables ****************************************


        textViewTest1=(TextView)findViewById(R.id.textViewTest1);
        textViewTest2=(TextView)findViewById(R.id.textViewTest2);
        textViewTest3=(TextView)findViewById(R.id.textViewTest3);
        textViewTest4=(TextView)findViewById(R.id.textViewTest4);
        imageViewTest1=(ImageView)findViewById(R.id.imageViewTest1);
        imageViewTest2=(ImageView)findViewById(R.id.imageViewTest2);
        imageViewTest3=(ImageView)findViewById(R.id.imageViewTest3);
        imageViewTest4=(ImageView)findViewById(R.id.imageViewTest4);
        viewTest1=(ConstraintLayout)findViewById(R.id.viewTest1);
        viewTest2=(ConstraintLayout)findViewById(R.id.viewTest2);
        viewTest3=(ConstraintLayout)findViewById(R.id.viewTest3);
        viewTest4=(ConstraintLayout)findViewById(R.id.viewTest4);
       //goPremium=(Button) findViewById(R.id.buttonFreeTrial);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        percentage=(TextView) findViewById(R.id.textViewPercentage);

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.nav_viewFood);
        bottomNavigationView.setSelectedItemId(R.id.navigation_tests);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_tests:
                      return true;

                    case R.id.navigation_profile:
                        startActivity(new Intent(getApplicationContext() , ProfileActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_food:
                        startActivity(new Intent(getApplicationContext() , FoodActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });




//********************************* Give Texts and Icons to Views ***************************************
        textViewTest1.setText(texts[0]); textViewTest2.setText(texts[1]);
        textViewTest3.setText(texts[2]); textViewTest4.setText(texts[3]);

        imageViewTest1.setImageDrawable(icon[0]); imageViewTest2.setImageDrawable(icon[1]);
        imageViewTest3.setImageDrawable(icon[2]); imageViewTest4.setImageDrawable(icon[3]);

        loadSharedPref();

        noOfCompletedTests=0;

        if(test1Done){viewTest1.setBackground(getDrawable(R.drawable.testtempdone)); noOfCompletedTests++;}
        if(test2Done){viewTest2.setBackground(getDrawable(R.drawable.testtempdone)); noOfCompletedTests++;}
        if(test3Done){viewTest3.setBackground(getDrawable(R.drawable.testtempdone)); noOfCompletedTests++;}
        if(test4Done){viewTest4.setBackground(getDrawable(R.drawable.testtempdone)); noOfCompletedTests++;}

        int percentageValue=(100*noOfCompletedTests/texts.length);
        progressBar.setProgress(percentageValue);
        percentage.setText(percentageValue+"%");

//**************************************** Set onClick Listeners ****************************************



        viewTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTest=1;
                Intent intent=new Intent(MainActivity.this , analysisTestActivity.class);
                startActivity(intent);

            }
        });

        viewTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTest=2;
                Intent intent=new Intent(MainActivity.this , analysisTestActivity.class);
                startActivity(intent);


            }
        });

        viewTest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTest=3;

               Intent intent=new Intent(MainActivity.this , analysisTestActivity.class);
                startActivity(intent);
            }
        });

        viewTest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTest=4;

                Intent intent=new Intent(MainActivity.this , analysisTestActivity.class);
                startActivity(intent);
            }
        });



    }

    //the use of sharedPreferences.. we load the data we need from sharedPreferences object that stores the data inside in the app data do restored everytime we use the application

    public void loadSharedPref(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        test1Done=sharedPreferences.getBoolean(TEST_1_DONE,false);
        test2Done=sharedPreferences.getBoolean(TEST_2_DONE,false);
        test3Done=sharedPreferences.getBoolean(TEST_3_DONE,false);
        test4Done=sharedPreferences.getBoolean(TEST_4_DONE,false);
        ProfileActivity.iq1=sharedPreferences.getFloat(ProfileActivity.IQ1,ProfileActivity.iq1);
        ProfileActivity.iq2=sharedPreferences.getFloat(ProfileActivity.IQ2,ProfileActivity.iq2);
        ProfileActivity.iq3=sharedPreferences.getFloat(ProfileActivity.IQ3,ProfileActivity.iq3);
        ProfileActivity.iq6=sharedPreferences.getFloat(ProfileActivity.IQ6,ProfileActivity.iq6);


    }


}
