/* 713. Subarray Product Less Than K

Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 */
class Solution 
{
    public int numSubarrayProductLessThanK(int[] nums, int k) 
    {
        int count = 0;
        int start = 0, end = 0;
        int product = 1;
        
        while (end < nums.length)
        {
            product *= nums[end];
            
            while (product >= k && start <= end)
                product /= nums[start++];

            if (product < k)
                count += end - start  + 1;
            ++end;
        }
        return count;
    }
}
