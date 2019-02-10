import java.util.*;
public class Project4 {

    /*
    Constants for Sim
    Bus Takes 180 seconds between stops
    Bus Waits 15 seconds at a stop
    Passengers take 2 seconds to get off and 3 seconds to get on
    Bus Ticket Costs: 3.00$
    */
    public static PQ agenda = new PQ();
    public static Stops route = new Stops();
    public static int load;   // The time interval between when pasengers get added to stops.
    public void userEntry()
    {
        Scanner kin = new Scanner(System.in);
        System.out.println("");
    }
    public static void main(String[] args) 
    {
        boolean displayAllData = false;     // Change this to true if you want to see all data generated, false it not.
        double timeToRunSim = 18000;    // Time is in Seconds 
        // Add the buses and their events to the agenda, 
        // A bus will be added every 180 seconds.
        // This will simulate buses pulling out of the HQ and driving to the route.
        SimulationStats maxProfit = new SimulationStats();
        SimulationStats minWaiting = new SimulationStats();
        SimulationStats minBuses = new SimulationStats();
        SimulationStats maxProfitAndMinWaiting = new SimulationStats();
        boolean moveOn = false;
        Scanner kin = new Scanner(System.in);
        
        while(moveOn == false)
        {
            try
            {
            System.out.println("The load is the time interval between passangers arriving in seconds. It must be a positive number.");
            System.out.print("Enter the load of the simulation: ");
            Project4.load = kin.nextInt();
            System.out.print("Enter the length of time for the simulation to run in seconds: ");
            timeToRunSim = kin.nextDouble();
            if(load > 0 && timeToRunSim > 0){moveOn = true;}
            else{System.out.println("INVALID INPUT");}
            }catch (InputMismatchException e){
                    moveOn = false;
                    System.out.println("INVALIVD INPUT");  
                    kin.next();
                }    
        }   
        for(int x = 0; x < 19; x++)
        {
            int z = 0;
            for(int y = x; y > -1; y--)
            {
                SimulationStats temp = runSim(y,z,timeToRunSim);
                if(displayAllData && temp != null){System.out.println(temp);}
                if(temp != null)
                {
                    if(temp.getTotalBuses() < minBuses.getTotalBuses()){minBuses = temp;}
                    if(temp.getProfit() > maxProfit.getProfit()){maxProfit = temp;}
                    if(temp.getAvgTimeInLine() < minWaiting.getAvgTimeInLine()){minWaiting = temp;} 
                    if(temp.getAvgTimeInLine() < maxProfitAndMinWaiting.getAvgTimeInLine() && temp.getProfit() > maxProfitAndMinWaiting.getProfit()){maxProfitAndMinWaiting = temp;}
                }
                z++;
            }
        }
        System.out.println("____________________________________");
        System.out.println("MAX PROFIT:");
        if(maxProfit.getFound() == true){System.out.println(maxProfit);}
        else    System.out.println("NONE FOUND");
        System.out.println("MIN BUSES: ");
        if(minBuses.getFound() == true){System.out.println(minBuses);}
        else    System.out.println("NONE FOUND");
        System.out.println("MIN WAITING: ");
        if(minWaiting.getFound() == true){System.out.println(minWaiting);}
        else    System.out.println("NONE FOUND");
        System.out.println("MAX PROFIT AND MINIMUM WAITING TIME");
        if(maxProfitAndMinWaiting.getFound() == true){System.out.println(maxProfitAndMinWaiting);}
        else    System.out.println("NONE FOUND");
    }
    public static SimulationStats runSim(int smallAmt,int largeAmt,double time)
    {
        int busCtr = 0;
        int lengthLargeBus = 60;
        int lengthSmallBus = 40;
        double mpgLarge = 4;    
        double mpgSmall = 6;
        double gasCost = 3.00;  // Estimate cost of 1 gallon diesel
        double speed = 35;  // Estimated average speed of bus on route
        double dirverHourlyWage = 15.00;
        Bus stats = new Bus(0,0);
        stats.setRevenue(0);
        Passenger.numPassengers = 0;
        Passenger.totalTimeInLine = 0;
        Passenger.totalTimeOnBus = 0;
        agenda = new PQ();
        route = new Stops();
        for(int x = 0; x < smallAmt; x++)
        {   
            Bus temp = new Bus(lengthSmallBus,0);
            busCtr++;
            Project4.agenda.add(new BusEvent(temp,0),busCtr * 180);
        }
        for(int x = 0; x < largeAmt; x++)
        {
            Bus temp = new Bus(lengthLargeBus,0);
            busCtr++;
            Project4.agenda.add(new BusEvent(temp,0),busCtr * 180);
        }        
        agenda.add(new PassengerArrivalEvent(0), 1);
        while(agenda.getCurrentTime()< time)
        {
            agenda.remove().run();
        }
        double costSmallBuses = (smallAmt)*(speed * (time/3600.0)) * (gasCost/mpgSmall);
        double costLargeBuses = (largeAmt)*(speed * (time/3600.0)) *(gasCost/mpgLarge);
        double costDrivers = (dirverHourlyWage/3600.0) * time;
        // Output for Simulation
        if(((stats.getRevenue() - (costSmallBuses + costDrivers + costLargeBuses))) > 0 )
        {
            SimulationStats temp = new SimulationStats(smallAmt,largeAmt,Passenger.numPassengers,(Passenger.totalTimeInLine/Passenger.numPassengers)/60.0
            ,(Passenger.totalTimeOnBus/Passenger.numPassengers)/60.0,costSmallBuses + costDrivers +costLargeBuses,stats.getRevenue(),(stats.getRevenue() - (costSmallBuses + costDrivers +costLargeBuses))); 
            return temp;
        }
        else return null;
    }
    
}
