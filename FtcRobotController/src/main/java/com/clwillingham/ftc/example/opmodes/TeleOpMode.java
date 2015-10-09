package com.clwillingham.ftc.example.opmodes;

import com.clwillingham.ftc.example.FTCRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by chris on 10/9/15.
 */
public class TeleOpMode extends OpMode {
    private FTCRobot robot;

    @Override
    public void init() {
        robot = new FTCRobot(hardwareMap);
    }

    @Override
    public void loop() {
        robot.tankDrive(gamepad1.left_stick_y, gamepad1.right_stick_y);
    }
}
