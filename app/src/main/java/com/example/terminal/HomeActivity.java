package com.example.terminal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CarouselPicker carouselPicker = findViewById(R.id.carousel);
        List<CarouselPicker.PickerItem> textItems = new ArrayList<>();
        //20 here represents the textSize in dp, change it to the value you want.
        textItems.add(new CarouselPicker.TextItem("¡", 20));
        textItems.add(new CarouselPicker.TextItem("hi", 20));
        textItems.add(new CarouselPicker.TextItem("!", 20));
        CarouselPicker.CarouselViewAdapter textAdapter = new CarouselPicker.CarouselViewAdapter(this, textItems, 0);
        carouselPicker.setAdapter(textAdapter);
    }
}