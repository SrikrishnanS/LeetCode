/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

*/

class Solution
{
    private void combinations(int start, int end, int k, Stack<Integer> S,
                              List<List<Integer>> L)
    {
        if (S.size() == k)
        {
            L.add(new ArrayList<Integer>(S));
            return;
        }

        for (int i = start; i <= end; ++i)
        {
            S.push(i);
            combinations(i + 1, end, k, S, L);
            S.pop();
        }
    }

    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> L = new ArrayList<>();

        combinations(1, n, k, new Stack<Integer>(), L);
        return L;
    }
}
