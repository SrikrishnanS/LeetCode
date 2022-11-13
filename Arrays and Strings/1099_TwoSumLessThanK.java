/*
1099. Two Sum Less Than K

Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.

*/

class Solution 
{
    public int twoSumLessThanK(int[] nums, int k) 
    {
        int l = 0, r = nums.length - 1;
        int result = -1;
        
        Arrays.sort(nums);
        
        while (l < r)
        {
            int sum = nums[l] + nums[r];
            if (sum < k)
            {
                result = Math.max(result, sum);
                ++l;
            }
            else
                --r;            
        }
        return result;
    }
}
