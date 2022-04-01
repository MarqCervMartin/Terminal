package com.example.terminal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class HomeActivity extends AppCompatActivity {

    private SharedPreferences pre;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Preferences
        initPreferences();

        //Carousel only for present data
        CarouselPicker carouselPicker = findViewById(R.id.carousel);
        List<CarouselPicker.PickerItem> textItems = new ArrayList<>();
        //20 here represents the textSize in dp
        textItems.add(new CarouselPicker.TextItem(username, 20));
        textItems.add(new CarouselPicker.TextItem(password, 20));
        CarouselPicker.CarouselViewAdapter textAdapter = new CarouselPicker.CarouselViewAdapter(this, textItems, 0);
        carouselPicker.setAdapter(textAdapter);
    }

    public void initPreferences(){
        //First we clear the preferences
        PreferenceManager.getDefaultSharedPreferences(this).edit().clear().apply();
        //Call to setDefaultValues for set values of XML preferences definitions
        PreferenceManager.setDefaultValues(this, R.xml.preferences, true);
        //get the values of the settings options
        pre = PreferenceManager.getDefaultSharedPreferences(this);
        //get the values of the settings options
        username = pre.getString("username", null);
        password = pre.getString("password", null);
    }
}