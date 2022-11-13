/*
217. Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

*/

class Solution
{
    public boolean containsDuplicate(int[] nums)
    {
        int i;
        Set<Integer> set = new HashSet<Integer>();
        
        for (i = 0; i < nums.length; ++i)
        {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}
