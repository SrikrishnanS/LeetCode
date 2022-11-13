/* 152. Maximum Product Subarray

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 */

class Solution
{
    public int maxProduct(int[] nums)
    {
        if (nums.length == 0)
            return nums.length;

        int minPre  = nums[0];
        int maxPre  = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; ++i)
        {
            int maxHere = Math.max(maxPre * nums[i], minPre * nums[i]);
                maxHere = Math.max(maxHere, nums[i]);

            int minHere = Math.min(minPre * nums[i], maxPre * nums[i]);
                minHere = Math.min(minHere, nums[i]);

            globalMax = Math.max(globalMax, maxHere);
            minPre = minHere;
            maxPre = maxHere;
        }
        return globalMax;
    }
}
