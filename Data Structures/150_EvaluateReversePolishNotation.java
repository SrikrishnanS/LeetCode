/* 150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 */
class Solution 
{
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> S  = new Stack<Integer>();
        
        for (String s : tokens)
        {
            if ("+".equals(s))
            {
                int num1 = S.pop();
                int num2 = S.pop();
                S.push(num2 + num1);
            }
            else if ("-".equals(s))
            {
                int num1 = S.pop();
                int num2 = S.pop();
                S.push(num2 - num1);
            }
            else if ("*".equals(s))
            {
                int num1 = S.pop();
                int num2 = S.pop();
                S.push(num2 * num1);
            }
            else if ("/".equals(s))
            {
                int num1 = S.pop();
                int num2 = S.pop();
                S.push(num2 / num1);
            }
            else
            {
                S.push(Integer.valueOf(s));
            }
        }
        return S.pop();
    }
}
