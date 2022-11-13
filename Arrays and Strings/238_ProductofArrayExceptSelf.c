/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

*/

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* productExceptSelf(int* nums, int numsSize, int* returnSize)
{
    int *res = malloc(numsSize * sizeof(int));
    int  i;
    int  prod;
    
    res[0] = 1;
    
    // left to right
    for (i = 1; i < numsSize; ++i)
        res[i] = res[i-1] * nums[i-1];
    
    // right to left
    prod = 1;
    for (i = numsSize - 1; i >= 0; --i)
    {
        res[i] = res[i] * prod;
        prod = prod * nums[i];
    }
    
    *returnSize = numsSize;
    return res;
}
