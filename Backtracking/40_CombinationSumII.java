/* 40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */

class Solution 
{
    private void searchSum(int []nums, int pos, int target,
                           Stack<Integer> S, List<List<Integer>> L)
    {
        if (target == 0)
        {
            L.add(new ArrayList<Integer>(S));
            return;
        }
        
        // we're here, meaning target is not reached yet
        for (int i = pos; i < nums.length; ++i)
        {
            if (i > pos && nums[i] == nums[i-1])
                continue;
            if (nums[i] > target)
                break; // only greater values ahead, so break
            S.push(nums[i]); // push current value to add to running sum
            searchSum(nums, i + 1, target - nums[i], S, L);
                          // look for left over sum (includes negative values)
            S.pop(); // pop last value to backtrack
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> L = new ArrayList<List<Integer>>();
        Stack<Integer> S = new Stack<Integer>();
        
        Arrays.sort(candidates); // array is sorted, comparison is easier
        searchSum(candidates, 0, target, S, L);
        return L;
    }
}
