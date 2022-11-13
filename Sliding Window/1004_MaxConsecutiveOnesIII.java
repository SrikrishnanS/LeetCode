/*
1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

*/

class Solution 
{
    public int longestOnes(int[] nums, int k) 
    {
        int start = 0, end = 0;    
        int zeros = 0;
        int  maxLen = 0;
        
        while (end < nums.length)
        {
            if (nums[end] == 0)
                ++zeros;

            while (zeros > k)
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
