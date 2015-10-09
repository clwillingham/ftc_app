package com.clwillingham.ftc.example.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Willingham on 10/3/2015.
 */
public class PhoneSensorController {
    SensorManager sensorManager;
    List<SensorEventListener> sensorEventListeners = new ArrayList<SensorEventListener>();

    public PhoneSensorController(Context appContext){
        sensorManager = (SensorManager)appContext.getSystemService(Context.SENSOR_SERVICE);
    }

    void waitUntil(Sensor sensor, final SensorCriteriaListener listener, int rate) throws InterruptedException {
        final SensorEventListener eventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(listener.sensorCriteriaCheck(event)){
                    synchronized (this){
                        this.notify();
                    }
                    sensorEventListeners.remove(this);
                    sensorManager.unregisterListener(this);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorEventListeners.add(eventListener);
        sensorManager.registerListener(eventListener, sensor, rate);
        synchronized (eventListener){
            eventListener.wait();
        }
    }

    void stop(){
        for(SensorEventListener listener : sensorEventListeners){
            listener.notify();
        }
    }

}
