/*
1283. Find the Smallest Divisor Given a Threshold

Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.

*/

class Solution
{
    public int smallestDivisor(int[] nums, int threshold) 
    {
        int l = 0, r = Integer.MAX_VALUE;    
    
        while (l < r)
        {
            int sum  = 0;
            int m    = l + (r - l)/2;   
        
            for (int n : nums)
                sum += Math.ceil((double)n / m);
        
            if (sum <= threshold)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}