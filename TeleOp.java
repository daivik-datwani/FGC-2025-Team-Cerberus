package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp()
public class MainOpmode extends OpMode {

    twoWheelDrive tdrive = new twoWheelDrive();
    IntakeStorageHang iSts = new IntakeStorageHang();

    @Override
    public void init() {
        tdrive.init(hardwareMap);
        iSts.init(hardwareMap);


    }
    @Override

    public void loop() {

        double forward = -gamepad1.right_stick_y;  // Forward/backward
        double rotate = gamepad1.right_stick_x;   // Turning

        tdrive.drive(forward, rotate);

        //hanging the robot
//        if (gamepad1.a){
//            // move the hanging mechanism forward
//            iSts.controlHanging(100);
//        }
//        if (gamepad1.b){
//            // move the hanging mechanism backwards
//            iSts.controlHanging(-100);
//        }
//        if (gamepad1.x){
//            // stop the hanging mechanism
//            iSts.controlHanging(0);
//        }

        if (gamepad1.dpad_up){
            // constantly rottate the hanging mechanism forward
            iSts.controlIntake(1);
        }
        if (gamepad1.dpad_down){
            // move the intake mechanism backwards (just in case we need it)
            iSts.controlIntake(-1);
        }
        if (gamepad1.dpad_right){
            // pause the intake me
            // chanism
            iSts.controlIntake(0);
        }


    }
