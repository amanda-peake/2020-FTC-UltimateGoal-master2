package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareUltimateGoal {

    //Wheels
    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;



    //outtake slingshot thingy
   public DcMotor outake1;
  //public DcMotor outake2;

    //leadscrew motor

    public DcMotor leadscrew;

    //intake pool noodle
    public CRServo intakeL;
    public CRServo intakeR;


    int driveTime;


    //-------------------------------------Initialization----------------------

    public void InitializeRobot(HardwareMap hardwareMap) {
        HardwareMap HWMap = hardwareMap;

        //initialize motors

        leftFront = HWMap.dcMotor.get("leftFront");
        leftBack = HWMap.dcMotor.get("leftBack");
        rightFront = HWMap.dcMotor.get("rightFront");
        rightBack = HWMap.dcMotor.get("rightBack");

       // leftoutake = HWMap.dcMotor.get("leftoutake");
        //rightoutake = HWMap.dcMotor.get("rightoutake");

        leadscrew = HWMap.dcMotor.get("leadscrew");

        intakeL = HWMap.crservo.get("intakeL");
        intakeR = HWMap.crservo.get("intakeR");

        outake1 = HWMap.dcMotor.get("outake1") ;
     //   outake2 = HWMap.dcMotor.get("outake2");


    }


    //------------------------------------Basic Driving--------------------

    public void DriveStraight(double power, long totalSeconds, int Direction) throws InterruptedException {

        leftFront.setPower(power * -Direction);
        leftBack.setPower(power * -Direction);
        rightFront.setPower(power * Direction);
        rightBack.setPower(power * Direction);

        Thread.sleep(totalSeconds);

        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }
//right = positive direction
    public void DriveTurn(double power, long totalSeconds, int Direction) throws InterruptedException {
        leftFront.setPower(power * -Direction);
        leftBack.setPower(power * -Direction);
        rightFront.setPower(power * -Direction);
        rightBack.setPower(power * -Direction);

        Thread.sleep(totalSeconds);


        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }

    public void DriveSideways(double power, long totalSeconds, int Direction) throws InterruptedException {
        leftFront.setPower(power * -Direction);
        leftBack.setPower(power * Direction);
        rightFront.setPower(power * -Direction);
        rightBack.setPower(power * Direction);

        Thread.sleep(totalSeconds);
        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }


//-----------------------------------------Outake/Intake------------------------------



   public void Intake (double power) {
       intakeL.setPower(power);
       intakeR.setPower(-power);
   }

   public void Slingshot (double power) {
        outake1.setPower(power);
       // outake2.setPower(power);
   }




// ----------------------------------------LeadScrew--------------------------

/*public void Ramp (double power, int encoderTarget) {
    leadscrew.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    leadscrew.setTargetPosition(encoderTarget);

    leadscrew.setPower(power);

    leadscrew.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    leadscrew.setPower(0);

 */

    public void Ramp (double power, long totalSeconds) throws InterruptedException {
        leadscrew.setPower(power);

        Thread.sleep(totalSeconds);

        leadscrew.setPower(0);
    }
}
 /*  public void Leadscrew (double power, int encoder, int Direction) {

        leadscrew.setTargetPosition(encoder * Direction);

        leadscrew.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leadscrew.setPower(power);

        while (leadscrew.isBusy()) ;

    }
    */











