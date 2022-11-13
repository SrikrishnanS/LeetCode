/* 402. Remove K Digits

Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 */
class Solution 
{
    private char charPeek(StringBuilder sb)
    {
        if (sb.length() > 0)
            return sb.charAt(sb.length() - 1);
        else
            return '\0';
    }
    private char charPop(StringBuilder sb)
    {
        if (sb.length() > 0)
        {
            char ch = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            return ch;
        }
        return '\0';
    }
    public String removeKdigits(String num, int k) 
    {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : num.toCharArray())
        {
            while (k > 0 && charPeek(sb) > ch)
            {
                charPop(sb);
                --k;
            }
            sb.append(ch);       
        }
        
        while (sb.length() > 0 && k > 0) // pop remaining chars
        {
            charPop(sb);
            --k;
        }
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
            
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
