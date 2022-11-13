/*
875. Koko Eating Bananas

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

*/

class Solution 
{
    public int minEatingSpeed(int[] piles, int hours) 
    {
        int l = 1;
        int r = 0;
        
        for (int p : piles)
            if (p > r)
                r = p;
        
        while (l < r)
        {
            int  time = 0;
            int  m = (l + r) / 2 ;

            // total time by eating m bananas in an hour
            for (int p : piles)
                time += Math.ceil((double) p / m);
            
            if (time <= hours)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}
