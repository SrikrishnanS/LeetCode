/*
244. Shortest Word Distance II

Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.

Implement the WordDistance class:

WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.

*/

class WordDistance
{
    private Map<String, List<Integer>> index;

    public WordDistance(String[] wordsDict)
    {
        this.index = new HashMap<String, List<Integer>>();

        for (int i = 0; i < wordsDict.length; ++i)
        {
            String w = wordsDict[i];
            this.index.putIfAbsent(w, new ArrayList<Integer>());
            this.index.get(w).add(i);
        }
    }

    public int shortest(String word1, String word2)
    {
        int           d = Integer.MAX_VALUE;
        List<Integer> l1 = this.index.get(word1);
        List<Integer> l2 = this.index.get(word2);

        int p1 = 0, p2 = 0;

        while (p1 < l1.size() && p2 < l2.size())
        {
            int idx1  = l1.get(p1);
            int idx2  = l2.get(p2);
            int diff  = Math.abs(idx1 - idx2);

            if (idx1 < idx2)
                ++p1;
            else
                ++p2;

            d = Math.min(d, diff);
        }
        return d;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */