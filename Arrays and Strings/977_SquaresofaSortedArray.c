/*
977. Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

*/
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortedSquares(int* nums, int numsSize, int* returnSize)
{
    int *res = (int *)malloc(numsSize * sizeof(int));
    int i, lo = 0, hi = numsSize-1;
    
    for (i = numsSize-1; i >= 0; --i)
    {
        if (abs(nums[lo]) < abs(nums[hi]))
        {
            res[i] = nums[hi] * nums[hi];
            --hi;
        }
        else
        {
            res[i] = nums[lo] * nums[lo];
            ++lo;
        }
    }
    
    *returnSize = numsSize;
    return res;
}