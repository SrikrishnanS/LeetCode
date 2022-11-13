/*
162. Find Peak Element

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

*/

int findPeakElement(int* nums, int numsSize)
{
    int l = 0, r = numsSize-1, m;
    
    while (l <= r)
    {
        m = l + (int)((r-l)/2);
        
        if (l==r)
            return l;        
        if (nums[m] > nums[m+1])
            r = m;
        else
            l = m+1;
    }
    return 0;
}
