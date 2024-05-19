package com.example.foodorderingapp.Activity.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.foodorderingapp.Activity.Domain.FoodDomain;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB  tinyDB;

    public ManagementCart(Context context){

        this.context=context;
        this.tinyDB=tinyDB;


    }

public  void  insertFood(FoodDomain item) {
    ArrayList<FoodDomain> listfood = getListCart ();
    boolean existAlready = false;
    int n = 0;
    for (int y = 0; y < listfood.size (); y++) {

        if (listfood.get (y).getTitle ().equals (item.getTitle ())) {

            existAlready = true;
            n = y;
            break;

        }
    }

    if (existAlready) {
        listfood.get (n).setNumberinCart (item.getNumberinCart ());

    } else {
        listfood.add (item);

    }

    tinyDB.putListObject ("CartList", listfood);
    Toast.makeText (context, "Added to your Cart", Toast.LENGTH_SHORT).show ();
}
public  ArrayList<FoodDomain> getListCart(){

        return tinyDB.getListObject ("CartList");
}

}


