/*
704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

*/

class Solution 
{
    public int search(int[] nums, int target) 
    {
        int l = 0, r = nums.length - 1;
    
        while (l <= r)
        {
            int m = l + ((r - l)/2);
        
            if (nums[m] == target)
                return m;
            else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return  -1;
    }
}
