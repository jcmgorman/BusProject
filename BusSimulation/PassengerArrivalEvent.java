public class PassengerArrivalEvent implements Event
{
    private int stopToAdd;
    
    PassengerArrivalEvent(int x){stopToAdd = x;}
    // Last 3 stops are downtown stops
    int[] randStopOdds = {8,8,7,7,6,6,5,4,3,2,1,0};
    double[] randTimeOdds =
    {(Project4.load + .75* Project4.load),(Project4.load + .75* Project4.load),
    (Project4.load + .5* Project4.load),(Project4.load + .5* Project4.load),(Project4.load + .5* Project4.load),
    (Project4.load + .2* Project4.load),(Project4.load + .2* Project4.load),(Project4.load + .2* Project4.load),(Project4.load + .2* Project4.load),
    (Project4.load),(Project4.load),
    (Project4.load - .2* Project4.load),(Project4.load - .2* Project4.load),(Project4.load - .2* Project4.load),(Project4.load - .2* Project4.load),
    (Project4.load - .5* Project4.load),(Project4.load - .5* Project4.load),(Project4.load - .5* Project4.load),
    (Project4.load - .75* Project4.load),(Project4.load - .75* Project4.load),};

    public void run() 
    {
        // Add a passenger to the stop queue
        Passenger temp = new Passenger(stopToAdd);
        if(temp.getDirection() == 0)    // Add to east bound queue
        {
            temp.setTimeEnterLine(Project4.agenda.getCurrentTime());
            Project4.route.getEastBound()[stopToAdd].add(temp);
        }
        else 
        {
            temp.setTimeEnterLine(Project4.agenda.getCurrentTime());
            Project4.route.getWestBound()[stopToAdd].add(temp);
        }    // Add to west bound queue
        // Schedule next PassengerArrivalEvent
        int randStop = randStopOdds[(int)(Math.random() * randStopOdds.length)];    // CHANGER LATER TO MATCH THE ODDS GIVEN IN INSTRUCTIONS
        double timeScheduled = randTimeOdds[(int)(Math.random() * randTimeOdds.length)];
        Project4.agenda.add(new PassengerArrivalEvent(randStop), timeScheduled);
    }

}
