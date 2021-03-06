
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "TeleopUltimateGoal")

public class TeleopUltimateGoal extends LinearOpMode {

    HardwareUltimateGoal Gerty = new HardwareUltimateGoal();


    @Override
    public void runOpMode() throws InterruptedException {

        System.out.println("Starting up");
        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();

        System.out.println("Initialize Robot");
        Gerty.InitializeRobot(hardwareMap);
        System.out.println("Robot Initialized");

        telemetry.addData("Status", "Ready!");

        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            double fwdBack = gamepad1.left_stick_y;
            double strafe = -gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            //start intake movement
            Gerty.Grabber.setPower(1);




            while (Gerty.leadscrew.isBusy()) {
                telemetry.addData("Leadscrew Positon", Gerty.leadscrew.getCurrentPosition());
                telemetry.update();
            }

            //telemetry.addData("Ramp encoder", Gerty.leadscrew.getCurrentPosition());
            //telemetry.update();

            if (gamepad1.start) {
                Gerty.leftFront.setPower((fwdBack + 1.5 * strafe - turn) * .25);
                Gerty.leftBack.setPower((fwdBack - 1.5 * strafe - turn) * .25);
                Gerty.rightFront.setPower((-fwdBack + 1.5 * strafe - turn) * .25);
                Gerty.rightBack.setPower((-fwdBack - 1.5 * strafe - turn) * .25);

            } else { // drive robot normally at full speed

                Gerty.leftFront.setPower((fwdBack + strafe - turn));
                Gerty.leftBack.setPower((fwdBack - strafe - turn));
                Gerty.rightFront.setPower((-fwdBack + strafe - turn));
                Gerty.rightBack.setPower((-fwdBack - strafe - turn));

            }

            if (gamepad2.a) {
                Gerty.Ramp(1,1000);
                Thread.sleep(1000);
            }
            else if (gamepad2.b) {
                Gerty.Ramp(1,3000);
                Thread.sleep(2000);
            }
            else if (gamepad2.y) {
                Gerty.Ramp(1, 4000);
                Thread.sleep(2000);
            }


            if (gamepad2.dpad_up) {
                Gerty.leadscrew.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                Gerty.leadscrew.setPower(.9);
            } else if (gamepad2.dpad_down) {
                Gerty.leadscrew.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                Gerty.leadscrew.setPower(-.9);
            } else {
                Gerty.leadscrew.setPower(0);
            }

            Gerty.Grabber.setPower(gamepad1.left_trigger);

            //Outake System//

            Gerty.outake1.setPower(gamepad2.right_trigger);

            Gerty.outake2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            Gerty.outake2.setPower(gamepad2.left_stick_y);

            if (gamepad2.left_bumper) {
                Gerty.outake2.setPower(-1);
            }
            else {
                Gerty.outake2.setPower(0);
            }

            if (gamepad2.right_bumper) {
                Gerty.outake1.setPower(1);
                Gerty.outake2.setPower(-1);
            }
            else {
                Gerty.outake2.setPower(0);
                Gerty.outake1.setPower(0);
            }





        }

        }


    }

















