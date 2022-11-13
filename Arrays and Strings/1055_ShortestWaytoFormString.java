/*
1055. Shortest Way to Form String

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.

*/

class Solution
{
    public int shortestWay(String source, String target)
    {
        Map<Character, List<Integer>> sourceMap = new HashMap<>();
        int way = 1;
        // get the character -> index mapping for source
        for (int i = 0; i < source.length(); ++i) O(S)
        {
            char ch = source.charAt(i);
            sourceMap.putIfAbsent(ch, new ArrayList<Integer>());
            sourceMap.get(ch).add(i); // record index for the character
        }

        int s = 0; // offset in the source
        int i = 0;
        while (i < target.length()) // O(T)
        {
            char ch = target.charAt(i);
            // if source does not contain a character in target
            if (!sourceMap.containsKey(ch))
                return -1;

            List<Integer> index = sourceMap.get(ch);
            int           j = Collections.binarySearch(index, s); // O(log(s))

            if (j < 0)
                j = -j - 1;

            if (j == index.size())
            {
                s = 0; // start search from beginning
                ++way; // move to next subsequence
            }
            else
            {
                s = index.get(j) + 1; // next index in need
                ++i;
            }
        }
        return way;
    }
}
