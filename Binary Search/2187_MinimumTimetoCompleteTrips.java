/*
2187. Minimum Time to Complete Trips

You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.

Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.

You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.

*/

class Solution
{
    public long minimumTime(int[] time, int totalTrips)
    {
        long l = 0, r = Long.MAX_VALUE;

        // optimal time is somewhere between l and r
        while (l < r)
        {
            long m = l + ((r - l)/2);
            long tripsPossible = 0;

            // how many trips possible
            for (int t  : time)
                tripsPossible += Math.floor(m / t);

            // find lower bound
            if (tripsPossible >= totalTrips)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}
