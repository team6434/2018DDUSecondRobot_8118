package frc.team8118.robot;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Strategy implements Subsystem {

    private double straightSpeed = 0.75;
    private double turnSpeed = 0.4;

    public Strategy() { }

    public void init() { }


    //logic for picking a strategy
    public Step[] pickStrategy()
    {
        String gameData;
        gameData = DriverStation.getInstance().getGameSpecificMessage();

        if(Character.toUpperCase(gameData.charAt(0)) == 'L') {
            return Left(); }
        else if(Character.toUpperCase(gameData.charAt(0)) == 'R'){
            return Right(); }
//        else {
            return baseLine();
//        }

    }



    public Step[] test()
    {
//        SmartDashboard.putString("Strategy", "Test");
        return new Step[]{
                new Straight(1, straightSpeed),
                new Eject()
        };
    }



    //TESTED
    public Step[] Left()
    {
        return new Step[]{
                new Straight(4, straightSpeed),
//                new Turn(-90, turnSpeed),
//                new Straight(2, straightSpeed),
//                new Turn(0, turnSpeed),
//                new Straight(2, straightSpeed),
//                new Eject()
        };
    }

    //TESTED
    public Step[] Right()
    {
        return new Step[]{
                new Straight(4, 0.7),
                new Eject()
                //use to be 4
        };
    }



    public Step[] baseLine()
    {
        return new Step[]{
                new Straight(6, straightSpeed)
        };
    }

    public void showDashboard()
    {
//        int readbotpos = (int)SmartDashboard.getNumber("robotPosition", 0);
//        SmartDashboard.putNumber("Check Position", readbotpos);
    }
}