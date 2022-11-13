/* 198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/

//With O(n) space:

#define max(a,b) \
    ((a > b) ? a : b)

int rob(int* nums, int numsSize)
{
    int  loot[numsSize];
    int  lastLoot;
    int i;
    
    if (numsSize == 1)
        return nums[0];
    
    loot[0] = nums[0];
    loot[1] = max(nums[0], nums[1]);
    
    for (i = 2; i < numsSize; ++i)
    {
        loot[i] = max(loot[i-1], loot[i-2] + nums[i]);
    }
    return loot[i-1];
}

// With O(1) space:

#define max(a,b) \
    ((a > b) ? a : b)

int rob(int* nums, int numsSize)
{
    int  p1;
    int  p2;
    int  cur;
    int  i = 2;
    
    if (numsSize == 1)
        return nums[0];
    
    p1 = nums[i-1];
    p2 = nums[i-2];
    p1 = max(p1, p2);
    for (i = 2; i < numsSize; ++i)
    {
        cur = max(p1, p2 + nums[i]);
        p2 = p1;
        p1 = cur;
    }
    return p1; // when i = maxsx, p1 is max previous loot
}
