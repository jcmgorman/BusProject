public class Bus 
{
    private Passenger[] seats;
    private int currentStop;
    private int direction;
    private double ticketCost = 3;
    private static double revenue;
    public Bus(int size, int dir)
    {
        seats = new Passenger[size];
        direction = dir;
    }
    public int getDirection(){return direction;}
    public int getCurrentStop(){return currentStop;}
    public double getRevenue(){return revenue;}
    public void setDirection(int x){direction = x;}
    public void setCurrentStop(int x){currentStop = x;}
    public void setRevenue(double x){revenue = x;}
    public boolean addPassenger(Passenger p)
    {
        for(int x = 0; x < seats.length; x++)
        {
            if(seats[x] == null)
            {
                seats[x] = p; 
                revenue+= ticketCost;
                seats[x].setTimeEnterBus(Project4.agenda.getCurrentTime());
                Passenger.totalTimeInLine += (seats[x].getTimeEnterBus() - seats[x].getTimeEnterLine());
                return true;
            }
        }
        return false;
    }
    public Passenger[] remove()
    {
        Passenger[] removed = new Passenger[seats.length];
        int ctr = 0;
        for(int x = 0; x < seats.length; x++)
        {
            if(seats[x] != null && seats[x].getStopOff() == currentStop)
            {
                removed[ctr] = seats[x];
                seats[x].setTimeLeaveBus(Project4.agenda.getCurrentTime() + (ctr * 2));
                Passenger.totalTimeOnBus += (seats[x].getTimeLeaveBus() - seats[x].getTimeEnterBus());
                ctr++;
                seats[x] = null;
            }
        }
        return removed;
    }
    public boolean isFull()
    {
        // If an empty seat is found then the buss is not full
        for(int x = 0; x < seats.length; x++)
        {
            if(seats[x] == null){return false;}
        }
        return true;
    }
}
