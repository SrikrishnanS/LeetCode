/*
254. Factor Combinations

Numbers can be regarded as the product of their factors.

For example, 8 = 2 x 2 x 2 = 2 x 4.
Given an integer n, return all possible combinations of its factors. You may return the answer in any order.

Note that the factors should be in the range [2, n - 1].

*/

class Solution
{
    private void getFactors (int start, int target, Stack<Integer> S,
                             List<List<Integer>> L)
    {
        if (target == 1 && S.size() > 1)
        {
            L.add(new ArrayList<Integer>(S));
            return;
        }

        for (int pos = start; pos <= target; ++pos)
        {
            if (target % pos == 0)
            {
                S.push(pos);
                getFactors(pos, target/pos, S, L);
                S.pop();
            }
        }

    }
    public List<List<Integer>> getFactors(int n)
    {
        List<List<Integer>> L = new ArrayList<List<Integer>>();

        if (n == 1)
            return L;

        getFactors(2, n, new Stack<Integer>(), L);
        return L;
    }
}