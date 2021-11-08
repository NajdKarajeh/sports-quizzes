package com.najd1182687.najd;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private ImageView popImageView1,popImageView2,popImageView3,popImageView4;
    private TextView textviewPS, textviewPB, textviewPF, textviewPO;
    private Spinner spinner;
    public static float iq1,iq2,iq3,iq6=0;
    public static final String IQ1 = "iq1_v",IQ2 = "iq2_v",IQ3 = "iq3_v",IQ4 = "iq4_v",IQ5 = "iq5_v",IQ6 = "iq6_v",IQ7 = "iq7_v",IQ8 = "iq8_v",IQ9="Iq9_v";
    private String Texter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        popImageView1=(ImageView) findViewById(R.id.imageViewP1);
        popImageView2=(ImageView) findViewById(R.id.imageViewP2);
        popImageView3=(ImageView) findViewById(R.id.imageViewP3);
        popImageView4=(ImageView) findViewById(R.id.imageViewP6);

        textviewPS=(TextView) findViewById(R.id.textViewPS);
        textviewPB=(TextView) findViewById(R.id.textViewPB);
        textviewPF=(TextView) findViewById(R.id.textViewPF);
        textviewPO=(TextView) findViewById(R.id.textViewPO);

        textviewPS.setText("%"+(int)iq1);
        textviewPB.setText("%"+(int)iq2);
        textviewPF.setText("%"+(int)iq3);
        textviewPO.setText("%"+(int)iq6);

        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sports, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(this);
        popImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  Texter=("Your Fitness & Workout Knowledge  = %"+(int)iq1);
                    onButtonShowPopupWindowClick(popImageView1);




            }
        });
        popImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Texter=("Your Soccer Knowledge  = %"+(int)iq2);
               onButtonShowPopupWindowClick(popImageView2);


            }
        });
        popImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Texter=("Your Basketball Knowledge = %"+(int)iq3);
               onButtonShowPopupWindowClick(popImageView3);

            }
        });

        popImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Texter=("Your Overall Sports Knowledge = %"+(int)iq6);
                onButtonShowPopupWindowClick(popImageView4);

            }
        });

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.nav_viewFood);
        bottomNavigationView.setSelectedItemId(R.id.navigation_profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_tests:
                        startActivity(new Intent(getApplicationContext() , MainActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.navigation_profile:
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
    }

    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.profile_popup, null);
        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        View myPoppyView = popupWindow.getContentView();
        TextView tv=(TextView)myPoppyView.findViewById(R.id.textViewPop);
       // myPoppyView.setB
        tv.setText(""+Texter);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text= adapterView.getItemAtPosition(i).toString();
        switch(text){
            case "Soccer Knowledge": { Texter=("Your Soccer Knowledge  = %"+iq1);
                onButtonShowPopupWindowClick(popImageView1); break;}
            case "Basketball Knowledge": { Texter=("Your Basketball Knowledge  = %"+iq2);
                onButtonShowPopupWindowClick(popImageView1); break;}
            case "Fitness Knowledge": { Texter=("Your Fitness & Workout Knowledge  = %"+iq3);
                onButtonShowPopupWindowClick(popImageView1); break;}
            case "Overall Sports Knowledge": { Texter=("Your Overall Sports Knowledge  = %"+iq6);
                onButtonShowPopupWindowClick(popImageView1); break;}
            default: { break;}
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
