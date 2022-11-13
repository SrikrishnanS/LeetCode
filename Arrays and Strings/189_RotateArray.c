/*
189. Rotate Array

Given an array, rotate the array to the right by k steps, where k is non-negative.

*/

#define SWAP(a, b) \
{              \
    a = (a) + (b); \
    b = (a) - (b); \
    a = (a) - (b); \
}

void reverse (int *nums, int start, int end)
{
    int i, j;
    
    for (i = start, j = end; i < j; i++, j--)
    {
        SWAP(nums[i], nums[j]);
    }
    
}

void rotate(int* nums, int numsSize, int k)
{
    k %= numsSize;
    reverse(nums, 0, numsSize - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, numsSize - 1);
}
