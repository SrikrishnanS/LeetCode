/*
287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

*/

class Solution
{
    public int findDuplicate(int[] nums)
    {
        int l = 0, r = nums.length - 1;

        // can't use extra space, so no sorting
        // find lower bound of answer
        // count of values < number
        while (l < r)
        {
            int m = l + ((r - l)/2);

            int count = 0;
            for (int n : nums)
                if (n <= m)
                    ++count;
            if (count > m)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}


