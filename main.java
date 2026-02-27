package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class twoWheelDrive {

    public DcMotor backLeft;
    public DcMotor backRight;

    public void init(HardwareMap hardwareMap) {
        backLeft = hardwareMap.dcMotor.get("back_left");
        backRight = hardwareMap.dcMotor.get("back_right");

        // Reverse left side motor so robot moves forward correctly
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void drive(double forward, double rotate) {
        double leftPower = forward + rotate;
        double rightPower = forward - rotate;

        // Normalize powers to stay within -1.0 to 1.0
        double maxPower = Math.max(Math.abs(leftPower), Math.abs(rightPower));
        if (maxPower > 1.0) {
            leftPower /= maxPower;
            rightPower /= maxPower;
        }

        backLeft.setPower(leftPower);
        backRight.setPower(rightPower);
    }
}
