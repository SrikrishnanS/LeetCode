/*
416. Partition Equal Subset Sum

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

*/

class Solution
{
    public boolean canPartition(int[] nums)
    {
        Boolean [][] found;
        int sum = 0;

        for (int n : nums)
            sum += n;

        if (sum % 2 == 1) // odd number sum, so can't split to 2
            return false;

        found = new Boolean[nums.length + 1][sum + 1];
        return canPartition(nums, nums.length, (sum / 2), found);
    }

    private boolean canPartition (int [] nums, int n, int target,
                                  Boolean [][] found)
    {
        boolean result;
        if (n == 0 || target < 0)
            return false;
        else if (target == 0)
            return true;
        else if (found[n][target] != null)
            return found[n][target];

        result = canPartition(nums, n - 1, target - nums[n - 1], found) ||
                 canPartition(nums, n - 1, target, found);
        found[n][target] = result;
        return result;
    }
}
