/* 523. Continuous Subarray Sum

Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 */
class Solution 
{
    public boolean checkSubarraySum(int[] nums, int k) 
    {
        Map <Integer, Integer> map = new HashMap<>();
        int sum = 0, mod;
        
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i)
        {
            sum += nums[i];
            mod = sum % k;
        
            if (!map.containsKey(mod)) // sum previously seen
                map.put(mod, i);
            else
                if (i - map.get(mod) > 1) // subarray length > 1
                    return true;
        }
        return false;
    }
}
