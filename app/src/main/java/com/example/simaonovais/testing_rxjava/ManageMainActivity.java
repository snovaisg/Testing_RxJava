package com.example.simaonovais.testing_rxjava;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.Callable;

import io.reactivex.Observable;


public class ManageMainActivity extends AppCompatActivity {

    private Activity activity;



    public ManageMainActivity(Activity a){
        this.activity = a;

    }

    Boolean state = false;

    public Boolean getState(){
        return this.state;
    }

    public void changeState(){
        this.state = !(this.state || this.state);
    }

    public void testButton(TextView tv){
        Log.d("simao","whatup");


        if (getState())
            tv.setText("Hello World!");
        else
            tv.setText("Goodbye World!");
        changeState();
    }

    public void setText(String text){
        TextView tv = findViewById(R.id.tv1);
        tv.setText(text);
    }
}
