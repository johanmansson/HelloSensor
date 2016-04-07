package com.example.johanmansson.hellosensor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;



public class CompassActivity extends AppCompatActivity {

    private Compass compass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);


        compass = new Compass(this);
        compass.compassView = (ImageView) findViewById(R.id.imageView);
        compass.degreeText = (TextView) findViewById(R.id.textViewD);

    }


    @Override
    protected void onResume() {
        super.onResume();
        compass.start();

    }

    @Override
    protected void onPause() {

        super.onPause();
        compass.stop();



    }



}
