/*
487. Max Consecutive Ones II

Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.

*/

class Solution 
{
    public int findMaxConsecutiveOnes(int[] nums) 
    {
        int start = 0, end = 0;    
        int zeros = 0;
        int  maxLen = 0;
        
        while (end < nums.length)
        {
            if (nums[end] == 0)
                ++zeros;

            while (zeros > 1)
            {
                if (nums[start] == 0)
                    --zeros;
                ++start;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            ++end;
        }
        return maxLen;
    }
}
