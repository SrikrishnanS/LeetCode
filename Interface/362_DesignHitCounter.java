/* 362. Design Hit Counter

Design a hit counter which counts the number of hits received in the past 5 minutes (i.e., the past 300 seconds).

Your system should accept a timestamp parameter (in seconds granularity), and you may assume that calls are being made to the system in chronological order (i.e., timestamp is monotonically increasing). Several hits may arrive roughly at the same time.

Implement the HitCounter class:

HitCounter() Initializes the object of the hit counter system.
void hit(int timestamp) Records a hit that happened at timestamp (in seconds). Several hits may happen at the same timestamp.
int getHits(int timestamp) Returns the number of hits in the past 5 minutes from timestamp (i.e., the past 300 seconds).
 */

class HitCounter 
{
    private Map<Integer, Integer> hits;

    public HitCounter() 
    {
        hits = new HashMap<Integer, Integer>();
    }
    
    public void hit(int timestamp) 
    {
        hits.put(timestamp, 1 + hits.getOrDefault(timestamp, 0));
    }
    
    public int getHits(int timestamp) 
    {
        int count = 0;
        
        for (int n = 300; n >= 1 && timestamp >= 0; --n, --timestamp)
            if (hits.containsKey(timestamp))
                count += hits.get(timestamp);
        
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
