/*
167. Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

*/

class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        int[] res = new int[2];
        int lo = 0;
        int hi = numbers.length-1;
        int sum;
        while(true)
        {
            sum = numbers[lo] + numbers[hi];
            if (sum == target)
            {
                res[0] = lo+1;
                res[1] = hi+1;
                    break;
            }
            else if (sum < target)
                ++lo;
            else
                --hi;
        }
        return res;
    }
}
