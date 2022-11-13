/* 241. Different Ways to Add Parentheses

Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
 */
class Solution 
{
    private Map<String, List<Integer>> cache = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) 
    {
        List<Integer> L = new ArrayList<>();
        int           len = expression.length();

        if (cache.containsKey(expression))
            return cache.get(expression);

        for (int i = 0; i < len; ++i)
        {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*')
            {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1, len);
            
                // evaluate both expressions
                List<Integer> L1 = diffWaysToCompute(left);
                List<Integer> L2 = diffWaysToCompute(right);
            
                // find all possible answers
                for (int x : L1)
                    for (int y : L2)
                        if (ch == '+')
                            L.add(x + y);
                        else if (ch == '-')
                            L.add(x - y);
                        else if (ch == '*')
                            L.add(x * y);
            }
        }
        // no operator, only number as a string
        if (L.isEmpty())
            L.add(Integer.valueOf(expression));

        cache.put(expression, L);
        
        return L;
    }
}
