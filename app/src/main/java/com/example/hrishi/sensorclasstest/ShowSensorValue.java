package com.example.hrishi.sensorclasstest;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class ShowSensorValue extends AppCompatActivity implements SensorEventListener {

    protected Sensor sensor1, sensor2, sensor3, sensor4;
    public TextView tv1, tv2, tv3, tv4, s1, s2, s3, s4;
    public Button button = (Button)findViewById(R.id.button);
    protected SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sensor_value);
        //SensorManager temp;
        tv1 = (TextView) findViewById(R.id.sensor1value);
        tv2 = (TextView) findViewById(R.id.sensor2value);
        tv3 = (TextView) findViewById(R.id.sensor3value);
        tv4 = (TextView) findViewById(R.id.sensor4value);
        s1 = (TextView) findViewById(R.id.sensor1);
        s2 = (TextView) findViewById(R.id.sensor2);
        s3 = (TextView) findViewById(R.id.sensor3);
        s4 = (TextView) findViewById(R.id.sensor4);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(ShowSensorValue.this, Graphs.class);
                startActivity(i);
            }
        });


        if (mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            sensor1 = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            s1.setText("Temperature");
        }
        else {
            s1.setText("Temperature Sensor Not Available");
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null){
            sensor2 = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
            s2.setText("Pressure");
        }
        else {
            s2.setText("Pressure Sensor Not Available");
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null){
            sensor3 = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            s3.setText("Light Intensity");
        }
        else {
            s3.setText("Light Sensor Not Available");
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) != null){
            sensor4 = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
            s4.setText("Relative Humidity");
        }
        else {
            s4.setText("Humidity Sensor Not Available");
        }
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }


    @Override
    public final void onSensorChanged(SensorEvent event) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.
        // Do something with this sensor value.
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            float lux = event.values[0];
            tv1.setText(Float.toString(lux));
        }
        if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {
            float lux = event.values[0];
            tv2.setText(Float.toString(lux));
        }
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lux = event.values[0];
            tv3.setText(Float.toString(lux));
        }
        if (event.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY) {
            float lux = event.values[0];
            tv4.setText(Float.toString(lux));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, sensor1, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, sensor2, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, sensor3, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, sensor4, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


}


