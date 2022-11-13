/* 22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
class Solution 
{
    private void generateParenthesis(int start, int end, int N, StringBuilder sb,
                                     List<String> L)
    {
        if (sb.length() == 2 * N)
        {
            L.add(sb.toString());
            return;
        }
        
        if (start <= N)
        {
            sb.append('(');
            generateParenthesis(start + 1, end, N, sb, L);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (start > end)
        {
            sb.append(')');
            generateParenthesis(start, end + 1, N, sb, L);
            sb.deleteCharAt(sb.length() - 1);
        }   
    }
    
    public List<String> generateParenthesis(int n) 
    {
        List<String> L = new ArrayList<>();
        
        generateParenthesis(1, 1, n, new StringBuilder(), L);
        return  L;
    }
}
