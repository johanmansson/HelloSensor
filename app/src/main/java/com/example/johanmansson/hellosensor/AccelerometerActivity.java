package com.example.johanmansson.hellosensor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;


public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager SM;
    private Sensor mySensor;
    private TextView x, y, z;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);


        // Create Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Assign TextView
        x = (TextView) findViewById(R.id.textViewX);
        y = (TextView) findViewById(R.id.textViewY);
        z = (TextView) findViewById(R.id.textViewZ);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText("X: " + event.values[0]);
        y.setText("Y: " + event.values[1]);
        z.setText("Z: " + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not in use
    }
}
