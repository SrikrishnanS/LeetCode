/* 1396. Design Underground System

An underground railway system is keeping track of customer travel times between different stations. They are using this data to calculate the average time it takes to travel from one station to another.

Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t)
A customer with a card ID equal to id, checks in at the station stationName at time t.
A customer can only be checked into one place at a time.
void checkOut(int id, string stationName, int t)
A customer with a card ID equal to id, checks out from the station stationName at time t.
double getAverageTime(string startStation, string endStation)
Returns the average time it takes to travel from startStation to endStation.
The average time is computed from all the previous traveling times from startStation to endStation that happened directly, meaning a check in at startStation followed by a check out from endStation.
The time it takes to travel from startStation to endStation may be different from the time it takes to travel from endStation to startStation.
There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.
You may assume all calls to the checkIn and checkOut methods are consistent. If a customer checks in at time t1 then checks out at time t2, then t1 < t2. All events happen in chronological order.
 */
class Travel
{
    String    stationName;  // station name
    int       time;         // time

    public Travel(){}
    public Travel(String stationName, int time)
    {
        this.stationName = stationName;
        this.time = time;
    }
}

class TravelTime
{
    int time;
    int trips;
    
    public TravelTime()
    {
        this(0, 0);
    }
    public TravelTime(int time, int trips)
    {
        this.time = time;
        this.trips = trips;
    }
}

class UndergroundSystem 
{
    Map<Integer, Travel> from;
    Map<String, TravelTime> trips;
    
    public UndergroundSystem() 
    {
        this.from = new HashMap<>();
        this.trips = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) 
    {
        Travel trip = new Travel(stationName, t);
        from.put(id, trip);
    }
    
    public void checkOut(int id, String stationName, int t) 
    {
        Travel      trip  = from.get(id);
        String      key   = trip.stationName + ":" + stationName;
        int         lapse = t - trip.time;
        TravelTime  tt;

        trips.putIfAbsent(key, new TravelTime());
        tt = trips.get(key);
        trips.put(key, new TravelTime(tt.time + lapse, tt.trips + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) 
    {
        TravelTime tt = trips.get(startStation + ":" + endStation);
        
        return (double) tt.time / tt.trips;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
