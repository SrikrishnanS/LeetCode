/* 269. Alien Dictionary

There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.
 */
class Solution
{
    Boolean[] visited = new Boolean[26];
    char[] order      = new char[26];
    int end = 26;
    public String alienOrder(String[] words)
    {
        Map<Character, Set<Character>> graph;
        
        // build an access friendly graph
        graph = getLexGraph(words);
        if (graph == null)
            return "";
        
        // walk through all the available characters in the graph
        for (char c : graph.keySet())
            if (!isSafe(graph, c))
                return "";

        return new String(order, end, order.length - end); // todo
    }
    
    private Map<Character, Set<Character>> getLexGraph(String[] words)
    {
        Map<Character, Set<Character>> graph;

        graph = new HashMap<Character, Set<Character>>();
        if (words.length == 1)
            for (int i = 0; i < words[0].length(); ++i)
                graph.put(words[0].charAt(i), null);
        
        for (int i = 0 ; i < words.length - 1; ++i)
        {
            String          s  = words[i];
            String          t  = words[i+1];
            int             j = 0;
            char            a;
            char            b;
            Set<Character>  next;
            
            if (!s.equals(t) && s.startsWith(t))
                return null;
            
            for (j = 0; j < s.length(); ++j)
                if (!graph.containsKey(s.charAt(j)))
                    graph.put(s.charAt(j), null);

            for (j = 0; j < t.length(); ++j)
                if (!graph.containsKey(t.charAt(j)))
                    graph.put(t.charAt(j), null);
            
            j = 0;
            do
            {
                a  = s.charAt(j);
                b  = t.charAt(j);            
                ++j;
            } while(a == b && j < s.length() && j < t.length());
            
            if (a != b)
            {
                // a < b per the alien language
                // so make a the parent of b
                next = graph.get(a);
                if (next == null)
                {
                    next = new HashSet<Character>();
                    graph.put(a, next);
                }
                next.add(b);
            }
        }
        return graph;
    }
    
    private boolean isSafe(Map<Character, Set<Character>> graph, char parent)
    {   
        Set<Character> children;
        if (visited[parent - 'a'] != null)
            return !visited[parent - 'a'];

        children = graph.get(parent);
        visited[parent - 'a'] = true;
        
        if (children != null)
            for (char c : children)
                if (!isSafe(graph, c))
                    return false;
                    
        visited[parent - 'a'] = false;
        order[--end] = parent;
        return true;
    }
}
