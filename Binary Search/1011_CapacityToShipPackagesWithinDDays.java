/*
1011. Capacity To Ship Packages Within D Days

A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

*/

class Solution 
{
    public int shipWithinDays(int[] weights, int days) 
    {
        int l = Integer.MIN_VALUE, r = 0;
        
        for (int w : weights)
        {
            l = Math.max(l, w); // max load that can be sent
            r += w; // sum of a
        }
        // answer is somwhere between l and r
        while (l < r)
        {
            int  m = ((l + r)/2); // load per day
            int  d = getNumberOfDays(weights, m); 
            
            if (d >= days) // more days required than permitted
                l = m + 1; // increase the load per day
            else
                r = m;  // decrease the load per day
        }
        return  l;
    }

    private int getNumberOfDays(int [] weights, int max)
    {
        int days = 0;
        int sum = 0;
        
        for (int w : weights)
        {
            sum += w;
            if (sum > max)
            {
                ++days;
                sum = w;
            }
        }        
        return days;
    }
}
