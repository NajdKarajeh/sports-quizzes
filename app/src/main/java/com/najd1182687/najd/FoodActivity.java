package com.najd1182687.najd;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    private ListView listview;
    private BottomNavigationView bottomNavigationView;
    private Gson gsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        listview= (ListView) findViewById(R.id.listView);
        ArrayList<String> foods= new ArrayList<String>();
        foods.add("Meat, fish or poultry, cooked:                 21gm protein");
        foods.add("Pumpkin seeds:                                       17gm protein");
        foods.add("Yogurt, Greek style:                                 14gm protein");
        foods.add("Cottage cheese:                                      13gm protein");
        foods.add("Hemp seeds:                                           13gm protein");
        foods.add("Firm tofu:                                                 12gm protein");
        foods.add("Beans, peas or lentils, cooked:            12gm protein");
        foods.add("Egg, chicken:                                          12gm protein");
        foods.add("Cheese:                                                   12gm protein");

        foods.add("Cow's milk:                                             21gm protein");
        foods.add("Peanuts:                                                 17gm protein");
        foods.add("Peanut butter (natural):                       14gm protein");
        foods.add("Almonds:                                               13gm protein");
        foods.add("Almond butter (plain):                         13gm protein");
        foods.add("Yogurt:                                                   12gm protein");
        foods.add("Fortified soy beverage:                        12gm protein");
        foods.add("Sunflower seeds:                                  12gm protein");
        foods.add("Sunflower seed butter (plain):              12gm protein");
        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,foods);
        listview.setAdapter(arrayAdapter);

        //implementing the bottomNavigationView:

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.nav_viewFood);
        bottomNavigationView.setSelectedItemId(R.id.nav_food);
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
                        startActivity(new Intent(getApplicationContext() , ProfileActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_food:
                        return true;
                }
                return false;
            }
        });
    }

    //the use of GSON LIBRARY (NEEDS to add a dependency inside gradle.build file)
    public static Collection<Gson> log(File destination, Gson log) {
        Collection<Gson> logs = null;
        if (destination.exists()) {
            Gson gson = new Gson();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(destination));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            logs = gson.fromJson(br, new TypeToken<List<Gson>>(){}.getType());
             logs.add(log);
        }
        return logs;
    }
}