/*
525. Contiguous Array

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

*/

class Solution 
{
    public int findMaxLength(int[] nums) 
    {
        int   maxLen  = 0;
        Map<Integer, Integer> pSum = new HashMap<>();
        int   currSum = 0;

        pSum.put(0, -1);
        for (int i = 0; i < nums.length; ++i)
        {
            currSum += (nums[i] == 0) ? -1 : 1;     
        
            if (pSum.containsKey(currSum))
                maxLen = Math.max(maxLen, i - pSum.get(currSum));
            else
                pSum.put(currSum, i);
        }
        
        return maxLen;
    }
}
