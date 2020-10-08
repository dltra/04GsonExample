package com.example.gsonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        System.out.println("Test: "+json);
    }
    public class SampleData {
        public int itemNumber;
        public String description;
        public int quantity;
    }
}