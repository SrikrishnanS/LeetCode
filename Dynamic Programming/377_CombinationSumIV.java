/* 377. Combination Sum IV

Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.
 */
class Solution 
{  
    public int combinationSum4(int[] nums, int target) 
    {
        int [] ways = new int [target + 1];
        
        ways[0] = 1;
        
        for (int sum = 1; sum <= target; ++sum)
            for (int n = 0; n < nums.length; ++n)
                if (sum >= nums[n])
                    ways[sum] += ways[sum - nums[n]];
        return  ways[target];
    }
}
