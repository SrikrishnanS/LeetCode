/*
325. Maximum Size Subarray Sum Equals k

Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. If there is not one, return 0 instead.

*/

class Solution 
{
    public int maxSubArrayLen(int[] nums, int k) 
    {
        int   maxLen  = 0;
        Map<Integer, Integer> pSum = new HashMap<>();
        int   currSum = 0;

        for (int i = 0; i < nums.length; ++i)
        {
            currSum += nums[i];
        
            // has sum been achieved?
            if (currSum == k)
                maxLen = i + 1;
        
            // is subarray sum present?
            if (pSum.containsKey(currSum - k))
                maxLen = Math.max(maxLen, i - pSum.get(currSum - k));
            
            // update prefix sum map with current sum
            // retain old value if it exists to get max length
            pSum.putIfAbsent(currSum, i);            
        }
        
        return maxLen;
    }
}
