/* 39. Combination Sum

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
class Solution 
{
    private void searchSum(int []nums, int pos, int target,
                           Stack<Integer> S, List<List<Integer>> sumList)
    {
        if (pos == nums.length || target < 0)
            return;
        if (target == 0)
        {
            sumList.add(new ArrayList<Integer>(S));
            return;
        }
        // we're here, meaning target is not reached yet
        for (int i = pos; i < nums.length; ++i)
        {
            S.push(nums[i]); // push current value to add to running sum
            searchSum(nums, i, target - nums[i], S, sumList);
                          // look for left over sum (includes negative values)
            S.pop(); // pop last value to backtrack
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> sumList = new ArrayList<List<Integer>>();
        Stack<Integer> S = new Stack<Integer>();
        searchSum(candidates, 0, target, S, sumList);
        return sumList;
    }
}
