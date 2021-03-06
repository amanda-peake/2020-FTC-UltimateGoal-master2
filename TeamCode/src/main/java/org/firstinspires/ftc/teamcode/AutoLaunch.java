package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "AutoLaunch")

//delivering wobble goal to second square, launching ring into goal, then parking

public class AutoLaunch extends LinearOpMode {

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

        Gerty.outake2.setPower(1);
        Gerty.DriveStraight(-.75,2000,1);
        Thread.sleep(1000);

        Gerty.outake2.setPower(1);
        Gerty.Launch(1,4000);
        Thread.sleep(100);

        Gerty.outake2.setPower(1);
        Gerty.DriveTurn(.5,500,1);
        Thread.sleep(1000);

        Gerty.DriveStraight(-.5,1000,1);
        Thread.sleep(1000);

        Gerty.DriveStraight(-.5,1000,-1);
        Thread.sleep(1000);

    }
}
