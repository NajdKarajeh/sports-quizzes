package com.najd1182687.najd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class analysisTestActivity extends AppCompatActivity {

    private ImageView hint;
    private ImageView buttonNext;
    private TextView TxtQ;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private ConstraintLayout testLayout;
    private long backPressedTimer;
    int c = 0;
    TextView qNumber;
    private static Chronometer chronometer;
    private boolean running;

    private String[] t1q=new String[15];
    private String[] t3q=new String[15];
    private String[] t2q=new String[15];
    private String[] t4q=new String[15];
    private String[] t1c=new String[60];
    private String[] t3c=new String[60];
    private String[] t2c=new String[60];
    private String[] t4c=new String[60];
    private String[] aa=new String[15];
    private String[] ac=new String[15];
    private String[] as=new String[15];
    private String[] ao=new String[15];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_test);

        //*************************************** Declare Test Soccer ************************************

        t1q[0]="1) What African country was the first ever to qualify for a World Cup?";
        t1q[1]="2) What is the record for red cards given in a single soccer game?";
        t1q[2]="3) What is a soccer field called?";
        t1q[3]="4) How old was the youngest professional soccer player?";
        t1q[4]="5) Who was the first British player to win league titles in four countries?";
        t1q[5]="6) Which country won the first women’s World Cup?";
        t1q[6]="7) Which type of football is another term for soccer?";
        t1q[7]="8)  Who won the first two FIFA Women’s World Player of the Year Awards?";
        t1q[8]="9) What was the fastest goal in World Cup history?";
        t1q[9]="10) What is the only country to have played in every single soccer World Cup?";
        t1q[10]="11) In soccer, what body part can’t touch the ball?";
        t1q[11]="12) Who won the first Ballon d'Or for men";
        t1q[12]="13) Which player won the most Ballon d'Ors ?";
        t1q[13]="14) Which player has scored most number of goals in total?";
        t1q[14]="15) How many teams have won the Champions League?";



        t1c[0]="Morocco"; t1c[1]="Algeria"; t1c[2]="Egypt"; t1c[3]="Tunisia";
        t1c[4]="6"; t1c[5]="16"; t1c[6]="26"; t1c[7]="36";
        t1c[8]="A Ring"; t1c[9]="A pitch"; t1c[10]="A Field"; t1c[11]="None";
        t1c[12]="12"; t1c[13]="13"; t1c[14]="14"; t1c[15]="15";
        t1c[16]="Zidan"; t1c[17]="David Beckham"; t1c[18]="Ronaldo"; t1c[19]="Cafu";
        t1c[20]="Germany"; t1c[21]="Brazil"; t1c[22]="The United Kingdom"; t1c[23]="The United States";
        t1c[24]="Arabic football"; t1c[25]="Chinese football"; t1c[26]="American football"; t1c[27]="Association football";
        t1c[28]="Julie Foudy"; t1c[29]="Mia Hamm"; t1c[30]="Tiffeny Milbrett"; t1c[31]="Bente Nordby";
        t1c[32]="22.0 seconds"; t1c[33]="10.8 seconds"; t1c[34]="30.0 seconds"; t1c[35]="60.0 seconds";
        t1c[36]="Italy"; t1c[37]="Spain"; t1c[38]="Argentina"; t1c[39]="Brazil";
        t1c[40]="Head"; t1c[41]="Shoulders"; t1c[42]="Knees"; t1c[43]="Hands";
        t1c[44]="Johann Cruyff"; t1c[45]="Stanley Matthews"; t1c[46]="Michel Platini"; t1c[47]="Ronaldo";
        t1c[48]="Lio Messi"; t1c[49]="Cristiano Ronaldo"; t1c[50]="Pelé"; t1c[51]="Johann Cruyff";
        t1c[52]="Romário"; t1c[53]="Pelé"; t1c[54]="Lio Messi"; t1c[55]="Cristiano Ronaldo";
        t1c[56]="18"; t1c[57]="19"; t1c[58]="21"; t1c[59]="22";

        //*************************************** Declare Test Basketball ************************************

        t2q[0]="1) Which basketball player was Michael Jordan nicknamed after when he was in high school?";
        t2q[1]="2) What team won the very first NBA game in 1946?";
        t2q[2]="3) Who was the youngest player to score 10,000 points in the NBA?";
        t2q[3]="4) Who was the first WNBA player to dunk in a playoff game?";
        t2q[4]="5) What team owns the longest winning streak in NBA history?";
        t2q[5]="6) When he was just in eighth grade, what NBA coach appeared on Late Night with David Letterman?";
        t2q[6]="7) Who was the first NBA player to test positive for COVID-19? ";
        t2q[7]="8) Who was the first NBA player to shatter a backboard?";
        t2q[8]="9) What are the two states in the United States that have yet to send a team to the NCAA?";
        t2q[9]="10) Who was the first-ever NBA player to score 2,000 points in a single season?";
        t2q[10]="11) What retired basketball player tried out for the Chicago White Sox in 1994?";
        t2q[11]="12) What sport starts with a tip-off or jump ball?";
        t2q[12]="13) What does NBA stand for?";
        t2q[13]="14) Basketball player, Scottie Pippen, has a word tattooed on his forearm. What does it say?";
        t2q[14]="15) What team won the very first NBA game in 1946?";


        t2c[0]="Larry Bird"; t2c[1]="Elgin Baylor"; t2c[2]="Paul Arizin"; t2c[3]="Magic Johnson";
        t2c[4]="The New York Knicks"; t2c[5]="Boston Celtics"; t2c[6]="Brooklyn Nets"; t2c[7]="Philadelphia 76ers";
        t2c[8]="Paul Arizin"; t2c[9]="LeBron James."; t2c[10]="Elgin Baylor"; t2c[11]="Larry Bird";
        t2c[12]="Sue Bird"; t2c[13]="Catlin Clark"; t2c[14]="Lisa Lislie"; t2c[15]="Brittney Griner";
        t2c[16]="The New York Knicks"; t2c[17]="Boston Celtics"; t2c[18]="Brooklyn Nets"; t2c[19]="Los Angeles Lakers";
        t2c[20]="Larry Bird"; t2c[21]="Frank Vogel."; t2c[22]="Elgin Baylor"; t2c[23]="Paul Arizin";
        t2c[24]="Catlin Clark"; t2c[25]="Rudy Gobert"; t2c[26]="Sue Bird"; t2c[27]="Lisa Lislie";
        t2c[28]="Clint Walker"; t2c[29]="James Amess"; t2c[30]="Jhony Crawford"; t2c[31]="Chuck Connors";
        t2c[32]="Alaska and Boston"; t2c[33]="New York and Washington"; t2c[34]="Texas and Florida"; t2c[35]="Alaska and Maine";
        t2c[36]="Clint Walker"; t2c[37]="George Yardly"; t2c[38]="James Amess"; t2c[39]="Jhony Crawford";
        t2c[40]="Michael Jordan"; t2c[41]="Elgin Baylor"; t2c[42]="Paul Arizin"; t2c[43]="Magic Johnson";
        t2c[44]="Tennis"; t2c[45]="Football"; t2c[46]="Soccer"; t2c[47]="Basketball";
        t2c[48]="National Swimming Association"; t2c[49]="National Soccer Association"; t2c[50]="National Football Association"; t2c[51]="National Basketball Association";
        t2c[52]="Honor"; t2c[53]="Knight"; t2c[54]="Pip"; t2c[55]="King";
        t2c[56]="The New York Knicks"; t2c[57]="Boston Celtics"; t2c[58]="Philadelphia 76ers"; t2c[59]="None";

        //*************************************** Declare Test Fitness ************************************

        t3q[0]="1) Which one of these exercises is effective for weight loss?";
        t3q[1]="2) What does HIIT stand for?";
        t3q[2]="3) How do you call the layer of fat around your waistline?";
        t3q[3]="4) Agonist muscles are responsible for relaxing.";
        t3q[4]="5) Asana is a yoga posture.";
        t3q[5]="6) Ab exercises are enough to burn your belly fat.";
        t3q[6]="7) The exercise called “Hundred” is part of:";
        t3q[7]="8) Which piece of equipment will be useless for the basic squat?";
        t3q[8]="9) Which exercise boosts metabolism 24 hours a day, seven days a week?";
        t3q[9]="10) This exercise tool uses your own body weight to loosen tight muscles and improve blood flow.";
        t3q[10]="11) Yoga poses designed to stretch and strengthen your body are called:";
        t3q[11]="12) Which woman was the first to star in an exercise program?";
        t3q[12]="13) What is the best way to rehydrate after exercise?\n";
        t3q[13]="14) How much high-intensity exercise should adults strive for each week?";
        t3q[14]="15) Walking just 2.5 hours a week can decrease your risk of developing this condition by as much as 60 percent.";


        t3c[0]="Balance exercises"; t3c[1]="Strength exercises"; t3c[2]="Cardio"; t3c[3]="Yoga";
        t3c[4]="High-intensity interval training"; t3c[5]="Heat"; t3c[6]="High-interval intensity training"; t3c[7]="High-interval intensity therapy";
        t3c[8]="Beer belly"; t3c[9]="Tummy"; t3c[10]="Love handles"; t3c[11]="Muffin top";
        t3c[12]="False"; t3c[13]="True"; t3c[14]="Can't be determined"; t3c[15]="None";
        t3c[16]="Yes"; t3c[17]="Can't determine"; t3c[18]="False"; t3c[19]="True";
        t3c[20]="False"; t3c[21]="True"; t3c[22]="Can't determine"; t3c[23]="None";
        t3c[24]="Yoga"; t3c[25]="Pilates"; t3c[26]="Jogging"; t3c[27]="Yogalates";
        t3c[28]="Dumbbells"; t3c[29]="Foam roller"; t3c[30]="Bar"; t3c[31]="Ankle weights";
        t3c[32]="kickboxing"; t3c[33]="yoga"; t3c[34]="Pilates"; t3c[35]="strength training";
        t3c[36]="exercise mat"; t3c[37]="foam roller"; t3c[38]="stability ball"; t3c[39]="resistance band";
        t3c[40]="pranas"; t3c[41]="asanas"; t3c[42]="chakras"; t3c[43]="stretches";
        t3c[44]="Jane Fonda"; t3c[45]="Suzanne Somers"; t3c[46]="Jillian Michaels"; t3c[47]="Debbie Drake";
        t3c[48]="drink fruit juice"; t3c[49]="drinks sports drinks"; t3c[50]="eat fruit"; t3c[51]="drink water";
        t3c[52]="30 minutes a week"; t3c[53]="75 minutes a week"; t3c[54]="120 minutes a week"; t3c[55]="140 minutes a week";
        t3c[56]="diabetes"; t3c[57]="arthritis"; t3c[58]="heart disease"; t3c[59]="emphysema";



        //*************************************** Declare Test 4 ************************************

        t4q[0]="1) What’s the diameter of a basketball hoop in inches?";
        t4q[1]="2) The Olympics are held every how many years?";
        t4q[2]="3) What sport is best known as the ‘king of sports’?";
        t4q[3]="4) What do you call it when a bowler makes three strikes in a row?";
        t4q[4]="5) What’s the national sport of Canada?";
        t4q[5]="6) How many dimples does an average golf ball have?";
        t4q[6]="7) What country has competed the most times in the Summer Olympics yet hasn’t won a gold medal?";
        t4q[7]="8) The classic 1980 movie called Raging Bull is about which real-life boxer?";
        t4q[8]="9) The Triple Crown award is given to a horse that wins which three races?";
        t4q[9]="10) In the 1971 Olympics, Nadia Comaneci was the first gymnast to score a perfect score. What country was she representing?";
        t4q[10]="11) Who has won more tennis grand slam titles, Venus Williams or Serena Williams?";
        t4q[11]="12) What country has competed the most times in the Summer Olympics yet hasn’t won any kind of medal?";
        t4q[12]="13) Which boxer fought against Muhammad Ali and won?";
        t4q[13]="14) Which golf tournament did Tiger Woods win by 12 strokes cementing his first-ever major championship win?";
        t4q[14]="15) How many medals did China win at the Beijing Olympics?";

        t4c[0]="12 inches"; t4c[1]="14 inches"; t4c[2]="16 inches"; t4c[3]="18 inches";
        t4c[4]="5 years"; t4c[5]="3 years"; t4c[6]="2 years"; t4c[7]="4 years";
        t4c[8]="Football"; t4c[9]="Volleyball"; t4c[10]="Soccer"; t4c[11]="Basketball";
        t4c[12]="Turkey"; t4c[13]="Greek"; t4c[14]="Romania"; t4c[15]="Cuba";
        t4c[16]="Swimming"; t4c[17]="Tennis"; t4c[18]="Lacrosse"; t4c[19]="Soccer";
        t4c[20]="36"; t4c[21]="136"; t4c[22]="236"; t4c[23]="336";
        t4c[24]="English"; t4c[25]="Americans"; t4c[26]="The Philippines"; t4c[27]="Egyptians";
        t4c[28]="Jake LaMotta"; t4c[29]="Ivan Lendl"; t4c[30]="Rafal Nadal"; t4c[31]="Serena Williams";
        t4c[32]="Prix de l'Arc de Triomphe"; t4c[33]="Belmont Stakes"; t4c[34]="The Kentucky Derby"; t4c[35]="The Preakness Stakes";
        t4c[36]="Greek"; t4c[37]="Egypt"; t4c[38]="Turkey"; t4c[39]="Romania";
        t4c[40]="Ivan Lendl"; t4c[41]="Rafal Nadal"; t4c[42]="Roger Federer"; t4c[43]="Serena Williams";
        t4c[44]="Liechtenstein"; t4c[45]="Egypt"; t4c[46]="KSA"; t4c[47]="Canada";
        t4c[48]="Sugar Ray"; t4c[49]="Muhammad Ali"; t4c[50]="Joe Frazier"; t4c[51]="Floyd Mayweather";
        t4c[52]="PGA Championship"; t4c[53]="The Open Championship"; t4c[54]="U.S. Open Championship"; t4c[55]="The Masters";
        t4c[56]="40"; t4c[57]="60"; t4c[58]="80"; t4c[59]="100";

        //*************************************** Declare True Answers ********************************
        aa[0]="3"; as[0]="3"; ac[0]="4"; ao[0]="4";
        aa[1]="4"; as[1]="1"; ac[1]="1"; ao[1]="4";
        aa[2]="3"; as[2]="3"; ac[2]="2"; ao[2]="3";
        aa[3]="1"; as[3]="4"; ac[3]="4"; ao[3]="1";
        aa[4]="2"; as[4]="4"; ac[4]="4"; ao[4]="3";
        aa[5]="4"; as[5]="1"; ac[5]="2"; ao[5]="4";
        aa[6]="4"; as[6]="2"; ac[6]="2"; ao[6]="3";
        aa[7]="2"; as[7]="4"; ac[7]="4"; ao[7]="1";
        aa[8]="2"; as[8]="4"; ac[8]="4"; ao[8]="3";
        aa[9]="4"; as[9]="2"; ac[9]="2"; ao[9]="4";
        aa[10]="4"; as[10]="2"; ac[10]="1"; ao[10]="4";
        aa[11]="2"; as[11]="4"; ac[11]="4"; ao[11]="1";
        aa[12]="1"; as[12]="4"; ac[12]="4"; ao[12]="3";
        aa[13]="4"; as[13]="2"; ac[13]="3"; ao[13]="4";
        aa[14]="4"; as[14]="1"; ac[14]="1"; ao[14]="4";

        //*************************************** Declare Stuff ************************************

        testLayout = (ConstraintLayout) findViewById(R.id.testLayout);
        switch (MainActivity.currentTest){
            case 1: {testLayout.setBackground(getDrawable(R.drawable.socerbg)); break;}
            case 2: {testLayout.setBackground(getDrawable(R.drawable.basketbg)); break;}
            case 3: {testLayout.setBackground(getDrawable(R.drawable.fitnessbg)); break;}
            case 4: {testLayout.setBackground(getDrawable(R.drawable.overallbg)); break;}
            default: {}
        }


        TxtQ = (TextView) findViewById(R.id.textViewQuestion);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        rb1 = (RadioButton) findViewById(R.id.radioButton10);
        rb2 = (RadioButton) findViewById(R.id.radioButton11);
        rb3 = (RadioButton) findViewById(R.id.radioButton5);
        rb4 = (RadioButton) findViewById(R.id.radioButton9);
        hint = (ImageView) findViewById(R.id.imageViewHint);
        buttonNext=(ImageView)findViewById(R.id.buttonNext);
        qNumber = (TextView) findViewById(R.id.textView3);

        TxtQ.setMovementMethod(new ScrollingMovementMethod());
        rb1.setMovementMethod(new ScrollingMovementMethod());
        rb2.setMovementMethod(new ScrollingMovementMethod());
        rb3.setMovementMethod(new ScrollingMovementMethod());
        rb4.setMovementMethod(new ScrollingMovementMethod());

        chronometer=(Chronometer) findViewById(R.id.chronometerOnly);
        startChronometer();

        rb1.setTag("1"); rb2.setTag("2"); rb3.setTag("3"); rb4.setTag("4");

        //************************************************************************************


      check();

        //**************************************************************************************


        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    unlock();
            }
        });

        //******************************************* Answering Process *******************************************

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(radioGroup.getCheckedRadioButtonId()!=-1){
                checkAnswer();}
                  nextQuestion();
                  check();
                if(c>=t1q.length-1) {
                    buttonNext.setImageDrawable(getDrawable(R.drawable.finishh));
                }
            }
        });
        }

        //*************************************** Declare Necessary Functions *********************************

    @Override
    public void onBackPressed() {
        if (backPressedTimer + 2000 > System.currentTimeMillis()) {
            finish();
        } else {
            Toast.makeText(this, "Press back again to quit", Toast.LENGTH_SHORT).show();
        }
        backPressedTimer = System.currentTimeMillis();

    }
    private void checkAnswer(){
        RadioButton rbSelected= findViewById(radioGroup.getCheckedRadioButtonId());
        if (MainActivity.currentTest==1&&rbSelected.getTag().equals(aa[c])){MainActivity.mathScore++;}
        else if (MainActivity.currentTest==2&&rbSelected.getTag().equals(ac[c])){MainActivity.mathScore++;}
        else if (MainActivity.currentTest==3&&rbSelected.getTag().equals(as[c])){MainActivity.mathScore++;}
        else if (MainActivity.currentTest==4&&rbSelected.getTag().equals(ao[c])){MainActivity.mathScore++;}
        else;
        radioGroup.clearCheck();
        rb1.setBackground(getDrawable(R.drawable.choice));
        rb2.setBackground(getDrawable(R.drawable.choice));
        rb3.setBackground(getDrawable(R.drawable.choice));
        rb4.setBackground(getDrawable(R.drawable.choice));


    }

    private void nextQuestion() {

        c++;
    }

    private void previousQuestion() {

        c--;
    }

    private void check() {
if(MainActivity.currentTest==1){
    if(c>=t1q.length){
        MainActivity.test1Done=true;
        Intent intent=new Intent(analysisTestActivity.this , scoreActivity.class);
        ProfileActivity.iq1=(float)(ProfileActivity.iq1+((MainActivity.mathScore*6.5)-1))/2;
        ProfileActivity.iq6=(float)(ProfileActivity.iq6+((MainActivity.mathScore*6.5)-3))/2;
        startActivity(intent);
        finish();
    }
    else {

        qNumber.setText(c+1+"/"+t1q.length);
        TxtQ.setText(t1q[c]);
        rb1.setText(t1c[c * 4]);
        rb2.setText(t1c[c * 4 + 1]);
        rb3.setText(t1c[c * 4 + 2]);
        rb4.setText(t1c[c * 4 + 3]);
    }
}

      else  if(MainActivity.currentTest==2) {
    if (c >= t2q.length) {
        MainActivity.test2Done=true;
        Intent intent=new Intent(analysisTestActivity.this , scoreActivity.class);
        ProfileActivity.iq2=(float)(ProfileActivity.iq2+((MainActivity.mathScore*6.5)-1))/2;
        ProfileActivity.iq6=(float)(ProfileActivity.iq6+((MainActivity.mathScore*6.5)-2))/2;
        startActivity(intent);
        finish();
    } else {

        qNumber.setText(c+1+"/"+t2q.length);
        TxtQ.setText(t2q[c]);
        rb1.setText(t2c[c * 4]);
        rb2.setText(t2c[c * 4 + 1]);
        rb3.setText(t2c[c * 4 + 2]);
        rb4.setText(t2c[c * 4 + 3]);
    }
}

    else  if(MainActivity.currentTest==3) {
    if (c >= t3q.length) {
        MainActivity.test3Done=true;
        Intent intent=new Intent(analysisTestActivity.this , scoreActivity.class);
        ProfileActivity.iq3=(float)(ProfileActivity.iq3+((MainActivity.mathScore*6.5)-1))/2;
        ProfileActivity.iq6=(float)(ProfileActivity.iq6+((MainActivity.mathScore*6.5)-2))/2;
        startActivity(intent);
        finish();
    } else {

        qNumber.setText(c+1+"/"+t3q.length);
        TxtQ.setText(t3q[c]);
        rb1.setText(t3c[c * 4]);
        rb2.setText(t3c[c * 4 + 1]);
        rb3.setText(t3c[c * 4 + 2]);
        rb4.setText(t3c[c * 4 + 3]);
    }
}

else  if(MainActivity.currentTest==4) {
    if (c >= t4q.length) {
        MainActivity.test4Done=true;
        Intent intent=new Intent(analysisTestActivity.this , scoreActivity.class);
        ProfileActivity.iq1=(float) (ProfileActivity.iq1+((MainActivity.mathScore*6.5)-1))/2;
        ProfileActivity.iq2=(float)(ProfileActivity.iq2+((MainActivity.mathScore*6.5)-2))/2;
        ProfileActivity.iq3=(float)(ProfileActivity.iq3+((MainActivity.mathScore*6.5)-3))/2;
        ProfileActivity.iq6=(float)(ProfileActivity.iq6+((MainActivity.mathScore*6.5)-3))/2;
        startActivity(intent);
        finish();
    } else {

        qNumber.setText(c+1+"/"+t4q.length);
        TxtQ.setText(t4q[c]);
        rb1.setText(t4c[c * 4]);
        rb2.setText(t4c[c * 4 + 1]);
        rb3.setText(t4c[c * 4 + 2]);
        rb4.setText(t4c[c * 4 + 3]);
    }
}
        /*/*else {
            stopChronometer();
            Intent intent = new Intent(analysisTestActivity.this, scoreActivity.class);
            startActivity(intent);
            finish();
        }*/


    }



    private  void startChronometer(){
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            running=true;
        }
    }


    private  void stopChronometer(){
        if(running){
            chronometer.stop();
            running=false;
        }
    }

    public void unlock(){


        if (MainActivity.currentTest==1){
            if(rb1.getTag().equals(aa[c])) rb1.setBackgroundColor(Color.GREEN);
            else if(rb2.getTag().equals(aa[c])) rb2.setBackgroundColor(Color.GREEN);
            else if(rb3.getTag().equals(aa[c])) rb3.setBackgroundColor(Color.GREEN);
            else if(rb4.getTag().equals(aa[c])) rb4.setBackgroundColor(Color.GREEN);
        }
      else  if (MainActivity.currentTest==2){
            if(rb1.getTag().equals(ac[c])) rb1.setBackgroundColor(Color.GREEN);
            else if(rb2.getTag().equals(ac[c])) rb2.setBackgroundColor(Color.GREEN);
            else if(rb3.getTag().equals(ac[c])) rb3.setBackgroundColor(Color.GREEN);
            else if(rb4.getTag().equals(ac[c])) rb4.setBackgroundColor(Color.GREEN);
        }
        else  if (MainActivity.currentTest==3){
            if(rb1.getTag().equals(as[c])) rb1.setBackgroundColor(Color.GREEN);
            else if(rb2.getTag().equals(as[c])) rb2.setBackgroundColor(Color.GREEN);
            else if(rb3.getTag().equals(as[c])) rb3.setBackgroundColor(Color.GREEN);
            else if(rb4.getTag().equals(as[c])) rb4.setBackgroundColor(Color.GREEN);
        }
        else  if (MainActivity.currentTest==4){
            if(rb1.getTag().equals(ao[c])) rb1.setBackgroundColor(Color.GREEN);
            else if(rb2.getTag().equals(ao[c])) rb2.setBackgroundColor(Color.GREEN);
            else if(rb3.getTag().equals(ao[c])) rb3.setBackgroundColor(Color.GREEN);
            else if(rb4.getTag().equals(ao[c])) rb4.setBackgroundColor(Color.GREEN);
        }

        else;

    }

    public static long getTime(){
        long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
        long time=elapsedMillis/1000;
        return time;
    }


}
//public class answer extends String{}