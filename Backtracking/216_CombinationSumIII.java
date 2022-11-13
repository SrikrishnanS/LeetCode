/* 216. Combination Sum III

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 */
class Solution 
{
    private void searchSum(int N, int K, int pos,
                           Stack<Integer> S, List<List<Integer>> L)
    {
        if (N == 0 && S.size() == K)
        {
            L.add(new ArrayList<Integer>(S));
            return;
        }
        
        // we're here, meaning N is not reached yet
        for (int i = pos; i <= 9; ++i)
        {
            if (i > N)
                break; // only greater values ahead, so break
            S.push(i); // push current value to add to running sum
            searchSum(N - i, K, i + 1, S, L);
                          // look for left over sum (includes negative values)
            S.pop(); // pop last value to backtrack
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> L = new ArrayList<List<Integer>>();
        Stack<Integer> S = new Stack<Integer>();
                
        searchSum(n, k, 1, S, L);
        return L;
    }
}
