package com.example.simaonovais.testing_rxjava;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ManageMainActivity maa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maa = new ManageMainActivity(this);

    }





    public void testRxJava(View v){
        testRx trx = new testRx();
        trx.begin();
    }

    public void testClick(View v){
        Log.d("simao","hey");
        TextView tv = findViewById(R.id.tv1);
        maa.testButton(tv);
    }
}
