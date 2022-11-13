/* 213. House Robber II

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
#define max(a,b) \
    ((a > b) ? a : b)

int rob0(int* nums, int start, int end)
{
    int  p1;
    int  p2;
    int  cur;
    int  i;

    
    p1 = nums[start+1];
    p2 = nums[start];
    p1 = max(p1, p2);
    for (i = start + 2; i <= end; ++i)
    {
        cur = max(p1, p2 + nums[i]);
        p2 = p1;
        p1 = cur;
    }
    return p1; // when i = maxsx, p1 is max previous loot
}

int rob(int* nums, int numsSize)
{
    int odd, even;
    if (numsSize == 0)
        return 0;
    else if (numsSize == 1)
        return nums[0];
    else if (numsSize == 2)
        return max(nums[0], nums[1]);
    even = rob0(nums, 0, numsSize - 2);
    odd  = rob0(nums, 1, numsSize - 1);
    return max(even, odd);
}
