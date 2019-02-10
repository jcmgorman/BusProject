
public class Passenger
{
    // Variables for statistics
    public static int numPassengers = 0;
    public static double totalTimeInLine = 0;
    public static double totalTimeOnBus = 0;
    private double timeEnterLine = 0;
    private double timeEnterBus = 0;
    private double timeLeaveBus =0 ;
    private int stopOn;
    private int stopOff;
    private int direction;  // 0 = going east, 1 = going west
    int[] randStopOdds = {8,8,7,7,6,6,5,4,3,2,1,0};
    public Passenger(int x)
    {
        stopOn = x;
        // stopOff is a random number from 0 to 8
        stopOff = randStopOdds[(int)(Math.random() * randStopOdds.length)];
        // direction is a random number from 0 to 1
        direction = (int)(Math.random() * 2);      
        numPassengers++;
    }
    public void setTimeEnterLine(double x){timeEnterLine = x;}
    public void setTimeEnterBus(double x){timeEnterBus = x;}
    public void setTimeLeaveBus(double x){timeLeaveBus = x;}
    public double getTimeEnterLine(){return timeEnterLine;}
    public double getTimeEnterBus(){return timeEnterBus;}
    public double getTimeLeaveBus(){return timeLeaveBus;}
    public int getDirection(){return direction;}
    public int getStopOff(){return stopOff;}
}
