/*
399. Evaluate Division

You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

*/

class Expression
{
    double  factor;
    String  variable;

    public Expression(double factor, String variable)
    {
        this.factor = factor;
        this.variable = variable;
    }
}

class Solution
{
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries)
    {
        double [] result = new double[queries.size()];

        // variable -> child expression equivalents
        Map<String, List<Expression>> graph  = new HashMap<>();
        Set<String> visited = new HashSet<String>();

        // create an access friendly graph
        for (int i = 0; i < equations.size(); ++i)
        {
            List<String>  e = equations.get(i);
            double        f = values[i];

            // (u = f * v) and (v = u * (1/f))
            String u = e.get(0);
            String v = e.get(1);

            graph.putIfAbsent(u, new ArrayList<Expression>());
            graph.putIfAbsent(v, new ArrayList<Expression>());

            graph.get(u).add(new Expression(f, v));
            graph.get(v).add(new Expression(1/f, u));
        }

        // find answer for each of the queries
        int end = -1;
        for (List<String> q : queries)
        {
            String src = q.get(0);
            String dest = q.get(1);

            visited.clear();

            double[] answer = new double[]{-1.0};

            hasPathResult(graph, 1, src, dest, visited, answer);
            result[++end] = answer[0];
        }
        return result;
    }

    private boolean hasPathResult(Map<String, List<Expression>> graph,
                                 double factor, String src, String dest,
                                 Set<String> visited, double[] answer)
    {
        List<Expression> children = graph.get(src);

        if (src.equals(dest))
        {
            if (graph.containsKey(src) && graph.containsKey(dest))
                answer[0] = factor;
            else
                answer[0] = -1.0;
            return true;
        }

        visited.add(src); // mark src as visited

        // is there a path to dest from here?
        if (children != null)
            for (Expression e : children)
                if (!visited.contains(e.variable) &&
                    hasPathResult(graph, factor * e.factor,
                                  e.variable, dest, visited, answer))
                    return true;
        return false;
    }
}
