package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeStorageHang {

    public DcMotor intakeMotor;
    public DcMotor hangingMotor;

    public void init(HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.dcMotor.get("intake");
        hangingMotor = hardwareMap.dcMotor.get("hanging");



    }
    public void controlIntake(double power) {
        intakeMotor.setPower(power);
    }
    public void controlHanging(double power) {
        hangingMotor.setPower(power);
    }

}
