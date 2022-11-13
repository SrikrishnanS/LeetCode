/*
930. Binary Subarrays With Sum

Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

*/

class Solution 
{
    public int numSubarraysWithSum(int[] nums, int goal) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;

        map.put(0, 1);
        for (int n : nums)
        {
            sum += n;
            count += map.getOrDefault(sum - goal, 0);
            map.put(sum, 1 + map.getOrDefault(sum, 0));
        }
        return count;
    }
}
