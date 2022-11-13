/* 209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
class Solution 
{
    public int minSubArrayLen(int target, int[] nums) 
    {
        int  start  = 0;
        int  end    = 0;
        int  minLen = Integer.MAX_VALUE;
        int  sum    = 0;
        
        while (end < nums.length)
        {
            sum += nums[end];
            while (start <= end && sum >= target)
            {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start++];
            }
            ++end;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
