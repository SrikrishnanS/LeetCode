/* 53. Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.
 */
#define max(a,b)\
 (((a) > (b)) ? (a) : (b))

int maxSubArray(int* nums, int numsSize)
{
    int cursum = nums[0];
    int maxsum = cursum;
    int i;
    for (i = 1; i < numsSize; ++i)
    {
        cursum = max(nums[i], cursum + nums[i]);
        maxsum = max(maxsum, cursum);
    }
    return maxsum;
}