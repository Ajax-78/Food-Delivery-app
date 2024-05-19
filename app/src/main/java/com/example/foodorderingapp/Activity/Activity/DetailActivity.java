package com.example.foodorderingapp.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodorderingapp.Activity.Domain.FoodDomain;
import com.example.foodorderingapp.Activity.Helper.ManagementCart;
import com.example.foodorderingapp.R;

public class DetailActivity extends AppCompatActivity {
 private Button addToCartBtn;
 private TextView plusBtn,minusBtn,titleTxt,feeTxt,descriptionTxt,numberOrderTxt,starTxt,caloryTxt,timeTxt;
 private ImageView picFood;
 private FoodDomain object;
 private int numberOrder=1;
 private ManagementCart managementCart;

    public DetailActivity (Button addToCartBtn) {
        this.addToCartBtn = addToCartBtn;
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_detail);
        managementCart =new ManagementCart (DetailActivity.this);
        initView();
        getBundle();

    }
    private  void   getBundle(){
        object=(FoodDomain)  getIntent ().getSerializableExtra ("object");

        int drawableResourceId=this.getResources ().getIdentifier (object.getPicUrl (),"drawable",this.getPackageName ());

        Glide.with(this).load(drawableResourceId)
                .into(picFood);

           titleTxt.setText (object.getTitle ());
           feeTxt.setText ("Rs"+object.getPrice ());
           descriptionTxt.setText (object.getDescription ());
           numberOrderTxt.setText (""+numberOrder);
           caloryTxt.setText (object.getEnergy ());
           starTxt.setText (object.getScore ()+"");
           timeTxt.setText (object.getTime ()+"min");
           addToCartBtn.setText ("add to cart" +Math.round (numberOrder*object.getPrice ()));

           plusBtn.setOnClickListener (new View.OnClickListener () {
               @Override
               public void onClick (View v) {
                   numberOrder=numberOrder+1;
                   numberOrderTxt.setText (""+numberOrder);
                   addToCartBtn.setText ("Add to cart Rs"+Math.round (numberOrder*object.getPrice ()));

               }
           });
           minusBtn.setOnClickListener (new View.OnClickListener () {
               @Override
               public void onClick (View v) {
                   numberOrder=numberOrder-1;
                   numberOrderTxt.setText ("" +numberOrder);
                   addToCartBtn.setText ("Add to cart $" + Math.round (numberOrder*object.getPrice () ));

               }
           });








    }
private void initView(){








    }
}
