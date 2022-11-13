/*
1106. Parsing A Boolean Expression

Return the result of evaluating a given boolean expression, represented as a string.

An expression can either be:

"t", evaluating to True;
"f", evaluating to False;
"!(expr)", evaluating to the logical NOT of the inner expression expr;
"&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner expressions expr1, expr2, ...;
"|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner expressions expr1, expr2, ...

*/

class Solution
{
    public boolean parseBoolExpr(String expression)
    {
        Map<String, Boolean> cache = new HashMap<String, Boolean>();

        // load the cache with truth table values
        cache.put("f", false);
        cache.put("t", true);
        cache.put("!(f)", true);
        cache.put("!(t)", false);
        cache.put("|(f,f)", false);
        cache.put("|(f,t)", true);
        cache.put("|(t,f)", true);
        cache.put("|(t,t)", true);
        cache.put("&(f,f)", false);
        cache.put("&(f,t)", false);
        cache.put("&(t,f)", false);
        cache.put("&(t,t)", true);
        return getValue(expression, cache);
    }

    // &(t,(f)),!(f)  -> [ "&(t,(f))",  "!(f)" ]
    // t,&(t,f)      -> ["t", "&(t, f)"]
    private List<String> getExpressions(String expression)
    {
        StringBuilder sb   = new StringBuilder();
        List<String>  list = new ArrayList<String>();
        int           balance = 0, i = 0;
        boolean       inside = false;

        while (i < expression.length())
        {
            char ch = expression.charAt(i);

            if (!inside && ch == ',')
            {
                list.add(sb.toString());
                sb = new StringBuilder();
                ++i;
                continue;
            }

            sb.append(ch);
            if (ch == '(')
            {
                ++balance;
                inside = true;
            }
            else if (ch == ')')
            {
                --balance;
                if (balance == 0)
                {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                    ++i; // skip next ',' if exists
                    inside = false;
                }
            }
            ++i;
        }

        if (sb.length() > 0) // flush remaining
            list.add(sb.toString());

        return list;
    }
    private boolean getValue(String expression, Map<String, Boolean> cache)
    {
        // pre-evaluated
        if (cache.containsKey(expression))
            return cache.get(expression);

        char   operator  = expression.charAt(0);
        int    exprLen   = expression.length();
        String subExpr   = expression.substring(2, exprLen - 1);


        // NOT operator
        if (operator == '!')
            return !getValue(subExpr, cache);

        List<String> expr = getExpressions(subExpr); // array of sub expressions

        // OR operator
        if (operator == '|')
        {
            for (String e : expr)
                if (getValue(e, cache))
                    return true; // short circuit
            return false;
        }

        // AND operator
        else
        {
            for (String e : expr)
                if (!getValue(e, cache))
                    return false; // short circuit
            return true;
        }
    }
}