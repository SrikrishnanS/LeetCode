/*
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

*/

class Solution
{
    public int longestConsecutive(int[] nums)
    {
        Set <Integer> seen   = new HashSet<Integer>();   
        int           maxLen = 0;
        int           curLen = 0;
        
        for (int n: nums)
            seen.add(n);
        
        for (int i = 0; i < nums.length; ++i)
        {
            int n = nums[i];
            if (!seen.contains(n-1))
            {
                curLen = 1;
                while (seen.contains(++n))
                    curLen++;
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
