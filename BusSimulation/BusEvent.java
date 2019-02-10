public class BusEvent implements Event
{
    private int currentStop;
    private Bus bus;
    public BusEvent(Bus temp, int x)
    {
        bus = temp;
        currentStop = x;
    }
    public void run() 
    {
        // Remove all passengers at the current stop
        Passenger[] removed = bus.remove();
        int offCtr = 0;
        for(int x = 0; x < removed.length && removed[x] != null; x++){offCtr++;}
        // Add Passengers to bus at the current stop
        int onCtr = 0;
        if(bus.getDirection() == 0) // If Bus is going east
        {
            for(int x = 0; x < Project4.route.getEastBound()[currentStop].length() && bus.isFull() == false; x++)
            {
                Passenger temp = Project4.route.getEastBound()[currentStop].remove();
                bus.addPassenger(temp);
                onCtr++;
            }
        }
        else
        {
            for(int x = 0; x < Project4.route.getWestBound()[currentStop].length() && bus.isFull() == false; x++)
            {
                Passenger temp = Project4.route.getWestBound()[currentStop].remove();
                bus.addPassenger(temp);
                onCtr++;
            }
        }
        // Add up All the times to determine the time till the next bus event
        double timeGettingOff = 2 * offCtr;
        double timeGettingOn = 3 * onCtr;
        double busWaitTime = 15;
        double busTripTime = 180;
        double totalTimeTillNextStop = timeGettingOff + timeGettingOn + busWaitTime + busTripTime;
        // Schedule the next Bus Event
        if(currentStop == 8 && bus.getDirection() == 0){bus.setDirection(1);}   // Bus is at the end of east route
        else if(currentStop == 0 && bus.getDirection() == 1){bus.setDirection(0);}   // Bus is at the end of west route
        else if(bus.getDirection() == 0){bus.setCurrentStop(bus.getCurrentStop() + 1);}  // Move up to next Stop on east route
        else{bus.setCurrentStop(bus.getCurrentStop() - 1);} // Move down to next Stop on west route
        Project4.agenda.add(new BusEvent(bus,bus.getCurrentStop()), totalTimeTillNextStop);
        
    }
    
}
