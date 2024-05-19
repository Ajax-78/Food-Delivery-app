package com.example.foodorderingapp.Activity.Activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Activity.Adapter.FoodListAdapter;
import com.example.foodorderingapp.Activity.Domain.FoodDomain;
import com.example.foodorderingapp.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodList;
    private RecyclerView recyclerViewFood;


    @Override
        public void onCreate (Bundle savedInstanceState) {
        setTheme (R.style.Base_Theme_Foodorderingapp);
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);


        initRecycleView ();
    }


    private void initRecycleView () {
        ArrayList<FoodDomain> items=new ArrayList<> ();
        items.add (new FoodDomain ("Indian food","best in town","puri",8988, 9,9,4,89));
        items.add (new FoodDomain( "rajbvv","kgngkjggk","roll",2872,232,323,23,2));
        items.add (new FoodDomain ("uggyg","ugygyg","paneer",68,98,9,79,90));

        recyclerViewFood=findViewById (R.id.view1);
        recyclerViewFood.setLayoutManager (new LinearLayoutManager (this,LinearLayoutManager.HORIZONTAL,false));

        adapterFoodList=new FoodListAdapter (items);
        recyclerViewFood.setAdapter (adapterFoodList);




    }
}