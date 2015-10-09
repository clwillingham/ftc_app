package com.clwillingham.ftc.example.opmodes;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.clwillingham.ftc.example.sensors.SensorUtils;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.RobotLog;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chris on 10/9/15.
 */
public class SensorOpMode extends OpMode {

    private SensorManager sensorManager;

    SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            //float[] rotation = SensorUtils.rotationVectorToOrientation(event.values);
            for(int i=0; i < event.values.length; i++){
                float value = event.values[i];
                telemetry.addData(event.sensor.getName() + " " + i, value);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    public void init() {
        sensorManager = (SensorManager)hardwareMap.appContext.getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        RobotLog.d("****Sensor Types*****");
        for(Sensor sensor : sensors){
            RobotLog.d(sensor.getName());
        }
        RobotLog.d("*********************");
    }

    @Override
    public void start() {
        sensorManager.registerListener(sensorListener, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {
        sensorManager.unregisterListener(sensorListener);
    }
}
