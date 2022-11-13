/*
833. Find And Replace in String

You are given a 0-indexed string s that you must perform k replacement operations on. The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.

To complete the ith replacement operation:

Check if the substring sources[i] occurs at index indices[i] in the original string s.
If it does not occur, do nothing.
Otherwise if it does occur, replace that substring with targets[i].
For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".

All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will not overlap.

For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
Return the resulting string after performing all replacement operations on s.

A substring is a contiguous sequence of characters in a string.

*/

class Solution 
{
    public String findReplaceString(String s, int[] indices,
                                    String[] sources, String[] targets) 
    {
        String        result = "";
        int           k  = indices.length;
        int           i;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        
        for (i = 0; i < k; ++i)
            if (s.startsWith(sources[i], indices[i]))
                map.put(indices[i], i);

        for (i = 0; i < s.length();)
        {
            if (map.containsKey(i))
            {
                result += targets[map.get(i)];
                i += sources[map.get(i)].length();
            }
            else
            {
                result +=  s.charAt(i);
                ++i;
            }
        }
        return result;
    }
}
