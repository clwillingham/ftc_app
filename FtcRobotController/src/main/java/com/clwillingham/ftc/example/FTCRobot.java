package com.clwillingham.ftc.example;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by chris on 10/9/15.
 */
public class FTCRobot {

    private final DcMotor leftDrive;
    private final DcMotor rightDrive;

    public FTCRobot(HardwareMap hardwareMap){
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    public void tankDrive(double leftPower, double rightPower){
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }

    public void forwardTime(double power, long milliseconds) throws InterruptedException {
        tankDrive(power, power);
        Thread.sleep(milliseconds);
        tankDrive(0, 0);
    }
}
