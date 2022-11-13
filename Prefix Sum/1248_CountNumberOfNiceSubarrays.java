/*
1248. Count Number of Nice Subarrays

Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

*/

class Solution 
{
    public int numberOfSubarrays(int[] nums, int k) 
    {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        for (int n : nums)
        {
            sum += ((n & 1) == 1) ? 1 : 0;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, 1 + map.getOrDefault(sum, 0));
        }
        return count;
    }
}