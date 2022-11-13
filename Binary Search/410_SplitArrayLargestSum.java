/*
410. Split Array Largest Sum

Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

*/

class Solution 
{
    public int splitArray(int[] nums, int maxSplits) 
    {
        int l = Integer.MIN_VALUE, r = 0;
        
        for (int n : nums)
        {
            l = Math.max(l, n);
            r += n;
        }
        
        // answer is somewhere between l and r
        while (l < r)
        {
            int m = l + (r - l)/2;
            
            if (getSplits(nums, m) <= maxSplits)
                r = m; // lower bound
            else
                l = m + 1;
        }
        return l;        
    }
    // subarray sum not exceeding maxSum, how many splits would it need?
    private int getSplits(int [] nums, int maxSum)
    {
        int sum = 0, splits = 1;
    
        for (int n : nums)
        {
            sum += n;
            if (sum > maxSum)
            {
                ++splits;
                sum = n; // exclude n
            }
        }
        return splits;
    }
}
