/* 78. Subsets

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
 */
class Solution 
{
    private void combinatorial(List<List<Integer>> powerSet,
                               List<Integer> list, int[]nums, int pos)
    {        
        powerSet.add(list);
        for (int j = pos; j < nums.length; ++j)
        {
            List<Integer> subSet = new ArrayList<Integer>(list);
            subSet.add(nums[j]);
            combinatorial(powerSet, subSet, nums, j + 1);
        }   
    }
    
    public List<List<Integer>> subsets(int[] nums)
    {    
        List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
        
        combinatorial(powerSet, new ArrayList<Integer>(), nums, 0);
        return powerSet;
    }
}
