package com.example.gsonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder().create();
        //convert a String to Object
        SampleData mSampleData = gson.fromJson( "{ itemNumber:1, description: \"Carrots\", quantity:31 }", SampleData.class);
        //convert Object to String
        String json = gson.toJson(mSampleData,SampleData.class);
        //create list of objects
        List<SampleData> list = new ArrayList<SampleData>();
        //instantiate list
        for (int i = 0; i < 20; i++) {
            list.add(new SampleData(i, "Item"+i, (int)(Math.random()*10) ));
        }
        //convert list of SampleData to String
        Type type = new TypeToken<List<SampleData>>() {}.getType();
        String listAsString = gson.toJson(list, type);
        System.out.println("Test: "+listAsString);
        //convert Json String to List of SampleData objects
        List<SampleData> fromJson = gson.fromJson(listAsString,type);
        for(SampleData x: fromJson){
            System.out.println("Test: " +x.itemNumber+":"+x.description+":"+x.quantity);
        }
    }
    public class SampleData {
        public int itemNumber;
        public String description;
        public int quantity;
        public SampleData(int i, String d, int q){
            itemNumber=i;
            description=d;
            quantity=q;
        }

    }
}