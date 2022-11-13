/* 46. Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
class Solution 
{
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void permute(int[] nums, int start, int end,
                         List<List<Integer>> results)
    {
        if (start == end)
        {
            List<Integer> items = new ArrayList<Integer>();

            for (int n : nums) items.add(n);
            
            results.add(items);
        }
        for (int i = start; i <= end; ++i)
        {
            swap(nums, start, i);
            permute(nums, start + 1, end, results);
            swap(nums, start, i);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        permute(nums, 0, nums.length - 1, results);
        return results;
    }
}

class Solution 
{
    private void combinatorial(List<List<Integer>> L,
                               Stack<Integer> S, int[]nums, int pos)
    {
        L.add(new ArrayList<Integer>(S));
        for (int j = pos; j < nums.length; ++j)
        {
            S.push(nums[j]); // add a new elem
            combinatorial(L, S, nums, j + 1); // combinatorial with new elem
            S.pop();// backtrack
        }   
    }
    
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> L = new ArrayList<List<Integer>>();
        Stack<Integer> S = new Stack<Integer>();
        combinatorial(L, S, nums, 0);
        return L;
    }
}
