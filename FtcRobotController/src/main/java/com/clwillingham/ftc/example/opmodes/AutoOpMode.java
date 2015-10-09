package com.clwillingham.ftc.example.opmodes;

import com.clwillingham.ftc.example.FTCRobot;
import com.clwillingham.ftc.example.sensors.PhoneSensorController;
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
    }

    @Override
    public void stopOpMode() {
        RobotLog.d("OpMode Stopped");
    }
}
