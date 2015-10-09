package com.clwillingham.ftc.example.sensors;

import android.hardware.SensorEvent;

/**
 * Created by Chris Willingham on 10/3/2015.
 */
public interface SensorCriteriaListener {
    boolean sensorCriteriaCheck(SensorEvent event);
}
