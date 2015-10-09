package com.clwillingham.ftc.example.opmodes;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

import com.clwillingham.ftc.example.FTCRobot;
import com.clwillingham.ftc.example.sensors.PhoneSensorController;
import com.clwillingham.ftc.example.sensors.SensorCriteriaListener;
import com.qualcomm.robotcore.util.RobotLog;

/**
 * Created by chris on 10/9/15.
 */
public class AutoOpMode extends SafeLinearOpMode {
    FTCRobot robot;
    PhoneSensorController sensors;

    @Override
    public void initOpMode() throws InterruptedException {
        robot = new FTCRobot(hardwareMap);
        sensors = new PhoneSensorController(hardwareMap.appContext);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        robot.forwardTime(1, 1000);
        Thread.sleep(500);
        robot.tankDrive(0.5, -0.5);
        sensors.waitUntil(Sensor.TYPE_MAGNETIC_FIELD, new SensorCriteriaListener() {
            @Override
            public boolean sensorCriteriaCheck(SensorEvent event) {
                return event.values[0] > 100;
            }
        }, SensorManager.SENSOR_DELAY_UI);
        robot.tankDrive(0, 0);
    }

    @Override
    public void stopOpMode() {
        RobotLog.d("OpMode Stopped");
        sensors.stop();
    }
}
