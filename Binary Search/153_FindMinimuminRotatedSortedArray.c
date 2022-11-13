/*
153. Find Minimum in Rotated Sorted Array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

*/

int findMin(int* nums, int numsSize)
{
    int l = 0, r = numsSize - 1;
    int m;
    
    if (nums[r] >= nums[0]) // array already sorted
        return nums[0];
        
    while (l <= r)
    {
        m = (r - l)/2 + l;
        
        if (nums[m] > nums[m+1])
            return nums[m+1];
        else if (nums[m] < nums[m-1])
            return nums[m];
        if (nums[m] >= nums[r]) // target on the right
            l = m + 1;
        else if (nums[m] < nums[r]) // target on the left
            r = m - 1;
    }
    return -1;
}