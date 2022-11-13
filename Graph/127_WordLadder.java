/* 127. Word Ladder

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
class Solution
{
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList)
    {
        Set<String> visited = new HashSet<String>();
        Queue<Pair<String, Integer>> Q;
        Set<String> set     = new HashSet<String>();

        Q = new LinkedList<Pair<String, Integer>>();
        set.addAll(wordList);
        
        // start with the beginWord
        visited.add(beginWord);
        Q.offer(new Pair<String, Integer>(beginWord, 1));
        
        while (!Q.isEmpty())
        {
            Pair<String, Integer> p = Q.poll();
            String str    = p.getKey();
            int    nwords = p.getValue();
            char[] strArr;
                
            // is this the end word?
            if (endWord.equals(str))
                return nwords;

            strArr = str.toCharArray();
            // make all possible modifications
            for (int l = 0; l < str.length(); ++l)
            {
                char old = strArr[l];
                for (char c = 'a'; c <= 'z'; ++c)
                {
                    String  newStr;

                    strArr[l] = c;
                    newStr = new String(strArr);

                    if (!visited.contains(newStr) && // not already tried
                        set.contains(newStr))        // a valid word
                    {
                        visited.add(newStr);
                        Q.offer(new Pair<String, Integer>(newStr, nwords + 1));
                    }
                }
                strArr[l] = old;
            }
        }
        return 0;
    }
}
