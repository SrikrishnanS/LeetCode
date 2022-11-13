/* 433. Minimum Genetic Mutation

A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.
 */
class Solution
{
    public int minMutation(String start, String end, String[] bank)
    {
        Set<String>   set       = new HashSet<String>();
        Queue<String> Q     = new LinkedList<String>();
        int           mutations = 0;
        char[]        choices   = new char[]{'A', 'C', 'G', 'T'} ;
        Set<String>   visited   = new HashSet<String>();

        for (String s: bank)
            set.add(s);
    
        visited.add(start);
        Q.offer(start);    
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            for (int i = 0; i < qSize; ++i)
            {
                String str = Q.poll();
                char [] newChars = str.toCharArray();

                // is the end string formed?
                if (end.equals(str))
                    return mutations;

                // make all possible mutations
                for (int pos = 0; pos < newChars.length; ++pos)
                {
                    char   old = newChars[pos];
                    for (char c : choices)
                    {
                        String newstr;

                        newChars[pos] = c;
                        newstr = new String(newChars); // make a mutation

                         // add the new string to the Q
                        if (set.contains(newstr) &&
                            !visited.contains(newstr))
                        {
                            visited.add(newstr);
                            Q.offer(newstr);
                        }
                    }
                    newChars[pos] = old;
                }
            }
            ++mutations;
        }   
        return -1;
    }
}
