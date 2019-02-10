public class Stops 
{
    // Contains the west bound queue and east bound queue
    // Since the last stop on the eastBound won't have a east bound queue and the same 
    // true for the west bound queue, the total number of queses is 18 insted of 20
    private Q<Passenger>[] eastBound = new Q[9];
    private Q<Passenger>[] westBound = new Q[9];
    public Stops()
    {
        for(int x = 0; x < eastBound.length; x++){eastBound[x] = new Q(10);}
        for(int y = 0; y < westBound.length; y++){westBound[y] = new Q(10);}
    }
    public Q<Passenger>[] getEastBound(){return eastBound;}
    public Q<Passenger>[] getWestBound(){return westBound;}    
}
