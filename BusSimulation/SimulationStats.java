public class SimulationStats 
{
    private int amountSmallBuses = 9999;
    private int amountLargeBuses = 9999;
    private int totalBuses = amountSmallBuses + amountLargeBuses;
    private int totalNumRiders = 0;
    private double avgTimeInLine = 99999;
    private double avgTimeOnBus = 0;
    private double costBus = 0;
    private double revenueBus = 0;
    private double profit = -1;
    private boolean found = false;
    public SimulationStats(){}
    public SimulationStats(int amtSmall, int amtLarge, int riders, double avgTime, double avgRide, double costB, double revBus, double prof)
    {
        found = true;
        amountSmallBuses = amtSmall;
        amountLargeBuses = amtLarge;
        totalBuses = amountSmallBuses + amountLargeBuses;
        totalNumRiders = riders;
        avgTimeInLine = avgTime;
        avgTimeOnBus = avgRide;
        costBus = costB;
        revenueBus = revBus;
        profit = prof;
    }
    public int getAmountSmallBuses(){return amountSmallBuses;}
    public int getAmountLargeBuses(){return amountLargeBuses;}
    public int getTotalBuses(){return totalBuses;}
    public double getAvgTimeInLine(){return avgTimeInLine;}
    public double getAvgTimeOnBus(){return avgTimeOnBus;}
    public double getCostBus(){return costBus;}
    public double getRevenue(){return revenueBus;}
    public double getProfit(){return profit;}
    public boolean getFound(){return found;}
    public String toString()
    {
        String rtr = "";
        rtr += "Amount of small buses: " + amountSmallBuses + " \n";
        rtr += "Amount of large buses: " + amountLargeBuses + "\n";
        rtr += "Total amount of buses: " + totalBuses + "\n";
        rtr += "Total number of riders: " + totalNumRiders + "\n";
        rtr += "Average time in line (min): " + avgTimeInLine + "\n";
        rtr += "Average time on bus (min): " + avgTimeOnBus + "\n";
        rtr += "Cost of buses ($): " + costBus + "\n";
        rtr += "Revenue from riders ($): " + revenueBus + "\n";
        rtr += "Total profit ($): " + profit + "\n";
        return rtr;
    }
}
